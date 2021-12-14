import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.border.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.util.ArrayList;


public class Square extends Login{


	String chat_tmp;
	public user_info myUF;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Square window = new Square("");
	//				window.frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the application.
	 */
	Square(String id) {

		System.out.println(id+" is 생성");
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id) {

		System.out.println(id+" is 생성후");
		ClientChatter chatter = super.chatter;
		String myID=id;

		try {
			myID = chatter.sendMSG_s("myin/1/");
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileInputStream fileStream = null;
		try {
			System.out.println("try in");
			fileStream = new FileInputStream("./user_test.dat");

			ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
			ArrayList<user_info> is_my_user = (ArrayList<user_info>) objectInputStream.readObject();
			objectInputStream.close();

			//System.out.println(is_my_user.size());

			for (int n = 0; n < is_my_user.size(); n++) {
				System.out.println("for in"+id);
				user_info temp = is_my_user.get(n);
				if (temp.ID.compareTo(id) == 0) {

					System.out.println("if in");
					myUF = temp;
					System.out.println(temp.ID);
					System.out.println(myUF.ID);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(1200, 1200/12*9));
		frame.setSize(1200,1200/12*9);
		frame.setLocationRelativeTo(null);
		frame.setTitle("십이장기");
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//////////////////////////////////////////////////////
		/////////////////////////////채팅 패널
		JPanel chatting = new JPanel();
		chatting.setBackground(UIManager.getColor("Button.background"));
		chatting.setBounds(0, 0, 825, 860);
		frame.getContentPane().add(chatting);
		chatting.setLayout(null);

		//	채팅이 보이는 영역
		JTextArea output = new JTextArea();

		output.setFont(new Font("MD개성체", Font.PLAIN, 20));
		output.setBounds(30, 30, 760, 750);
		output.setBackground(Color.WHITE);
		output.setEditable(false);
		chatting.add(output);

		//채팅을 입력하는 칸
		JTextField input = new JTextField(20);
		input.setBounds(30, 805, 675, 35);
		input.setText("채팅을 입력하세요");
		chatting.add(input);

		//입력 버튼
		JButton input_btn = new JButton("입력");
		input_btn.setSize(76, 40);
		input_btn.setLocation(717, 802);
		input_btn.setBackground(Color.LIGHT_GRAY);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chat_tmp = input.getText();

				try {
					int get = chatter.sendMSG("all/2/" +myUF.nick+"/"+chat_tmp);
					if(get == 13){
						chatter.sendMSG_s(chat_tmp);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				LocalTime now = LocalTime.now();
				output.append(" >>> "+chat_tmp+"     "+now.getHour()+":"+now.getMinute()+":"+now.getSecond()+"\n");
				input.setText("");
				input.requestFocus();

			}
		});
		input_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chat_tmp = input.getText();
				try {
					int get = chatter.sendMSG("all/1/"+chat_tmp);
					if(get == 13){
						chatter.sendMSG_s(chat_tmp);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				LocalTime now = LocalTime.now();
				output.append(" >>> "+chat_tmp+"     "+now.getHour()+":"+now.getMinute()+":"+now.getSecond()+"\n");
				input.setText("");
				input.requestFocus();

			}
		});
		chatting.add(input_btn);
		//새로고침 버튼
		JButton re_btn = new JButton("r");
		re_btn.setSize(20, 20);
		re_btn.setLocation(717, 782);
		re_btn.setBackground(Color.GREEN);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		chatting.add(re_btn);









		//////////////////////////////////////////////////////
		////////////////// 대기실 패널
		JPanel room_list = new JPanel();
		room_list.setBackground(UIManager.getColor("Button.background"));
		room_list.setBounds(825, 37, 359, 520);
		frame.getContentPane().add(room_list);
		room_list.setLayout(null);
		//유저 버튼
		JButton users_btn = new JButton("USERS");
		users_btn.setBackground(Color.GRAY);
		users_btn.setFont(new Font("굴림", Font.BOLD, 18));
		users_btn.setBounds(41, 24, 289, 50);
		users_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		room_list.add(users_btn);
		////게임방 버튼
		//JButton room_btn = new JButton("ROOM");
		//room_btn.setBackground(Color.LIGHT_GRAY);
		//room_btn.setFont(new Font("굴림", Font.BOLD, 18));
		//room_btn.setLocation(41, 24);
		//room_btn.setSize(145, 50);
		//room_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		//room_list.add(room_btn);


		////////////////////////////////////////////////
		///////////유저목록 패널
		JPanel users_list = new JPanel();
		users_list.setBackground(Color.LIGHT_GRAY);
		users_list.setBounds(41, 72, 289, 400);
		room_list.add(users_list);
		users_list.setLayout(null);
		users_list.setVisible(true);
		users_list.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		//////////////////////////////////////////////////
		/////////////게임방 패널
		//JPanel rooms_list = new JPanel();
		//rooms_list.setBackground(Color.LIGHT_GRAY);
		//rooms_list.setBounds(41, 72, 289, 400);
		//room_list.add(rooms_list);
		//rooms_list.setLayout(null);
		//rooms_list.setVisible(true);
		//rooms_list.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		/*
		int room1_tmp=0;
		JButton room1 = new JButton("ROOM 1"+"              "+room1_tmp+" / 2");
		room1.setBounds(24, 30, 240, 35);
		rooms_list.add(room1);
		room1.setFont(new Font("굴림", Font.BOLD, 15));
		room1.setBackground(Color.LIGHT_GRAY);

		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (room1_tmp==2) {
					JOptionPane.showMessageDialog(null,"방에 접속할 수 없습니다.");
				}
			}
		});

		int room2_tmp=0;
		JButton room2 = new JButton("ROOM 2"+"              "+room2_tmp+" / 2");
		room2.setBackground(Color.LIGHT_GRAY);
		room2.setFont(new Font("굴림", Font.BOLD, 15));
		room2.setBounds(24, 85, 240, 35);
		rooms_list.add(room2);

		room2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (room2_tmp==2) {
					JOptionPane.showMessageDialog(null,"방에 접속할 수 없습니다.");
				}
			}
		});

		int room3_tmp=0;
		JButton room3 = new JButton("ROOM 3"+"              "+room3_tmp+" / 2");
		room3.setFont(new Font("굴림", Font.BOLD, 15));
		room3.setBounds(24, 140, 240, 35);
		room3.setBackground(Color.LIGHT_GRAY);
		rooms_list.add(room3);

		room3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (room3_tmp==2) {
					JOptionPane.showMessageDialog(null,"방에 접속할 수 없습니다.");
				}
			}
		});



		int room4_tmp=2;
		JButton room4 = new JButton("ROOM 4"+"              "+room4_tmp+" / 2");
		room4.setFont(new Font("굴림", Font.BOLD, 15));
		room4.setBounds(24, 195, 240, 35);

		room4.setBackground(Color.LIGHT_GRAY);
		rooms_list.add(room4);

		room4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (room4_tmp==2) {
					JOptionPane.showMessageDialog(null,"방에 접속할 수 없습니다.");
				}
			}
		});

*/
		//////////////////////////////////////////////
		/////////내정보 패널/////////////////////////////
		//////////////////////////////////////////////
		JPanel user_info = new JPanel();
		user_info.setBounds(866, 556, 289, 280);
		user_info.setLayout(null);
		user_info.setBorder((new LineBorder(Color.LIGHT_GRAY,4)));
		frame.getContentPane().add(user_info);
		//인포 타이틀
		JTextField info_title = new JTextField("User info");
		info_title.setEditable(false);
		info_title.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_title.setHorizontalAlignment(SwingConstants.CENTER);
		info_title.setFont(new Font("굴림", Font.BOLD, 20));
		info_title.setBounds(12, 28, 230, 29);
		user_info.add(info_title);
		//인포 아이디
		JTextField info_ID = new JTextField("ID : "+myUF.ID);
		info_ID.setEditable(false);
		info_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_ID.setFont(new Font("굴림", Font.BOLD, 20));
		info_ID.setBounds(49, 70, 230, 29);
		user_info.add(info_ID);
		//인포 닉네임
		JTextField info_NIC = new JTextField("Nick : "+myUF.nick);
		info_NIC.setEditable(false);
		info_NIC.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_NIC.setFont(new Font("굴림", Font.BOLD, 20));
		info_NIC.setBounds(49, 100, 230, 29);
		user_info.add(info_NIC);
		//인포 메일
		JTextField info_MAIL = new JTextField("E-mail : "+myUF.email.substring(0,myUF.email.indexOf("@")));
		info_MAIL.setEditable(false);
		info_MAIL.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_MAIL.setFont(new Font("굴림", Font.BOLD, 14));
		info_MAIL.setBounds(49, 130, 230, 29);
		user_info.add(info_MAIL);
		//인포 메일2
		JTextField info_MAIL2 = new JTextField("   "+myUF.email.substring(myUF.email.indexOf("@")));
		info_MAIL2.setEditable(false);
		info_MAIL2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_MAIL2.setFont(new Font("굴림", Font.BOLD, 14));
		info_MAIL2.setBounds(49, 160, 230, 29);
		user_info.add(info_MAIL2);
		//인포 sns
		JTextField info_SNS = new JTextField("SNS : "+myUF.sns);
		info_SNS.setEditable(false);
		info_SNS.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_SNS.setFont(new Font("굴림", Font.BOLD, 20));
		info_SNS.setBounds(49, 190, 230, 29);
		user_info.add(info_SNS);
		//전적
		JTextField info_WIN = new JTextField(myUF.game_record);
		info_WIN.setEditable(false);
		info_WIN.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		info_WIN.setFont(new Font("굴림", Font.BOLD, 20));
		info_WIN.setBounds(49, 220, 230, 29);
		user_info.add(info_WIN);
		//상세정보
		JButton more = new JButton("more ->");
		more.setForeground(Color.BLUE);
		more.setBackground(new Color(240,240,240));
		more.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 13));
		more.setBounds(181, 250, 80, 25);
		more.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		user_info.add(more);
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});



		////게임방 버튼동작
		//room_btn.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//		room_btn.setBackground(Color.LIGHT_GRAY);
		//		users_btn.setBackground(Color.GRAY);
		//		rooms_list.setVisible(true);
		//		users_list.setVisible(false);
//
		//	}
		//});

		//유저방 버튼동작
		users_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users_btn.setBackground(Color.LIGHT_GRAY);
				//room_btn.setBackground(Color.GRAY);
				//rooms_list.setVisible(false);
				users_list.setVisible(true);
			}
		});
	}
}