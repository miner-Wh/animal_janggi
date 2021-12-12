import java.awt.Dimension;
import java.awt.EventQueue;
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


public class Square {
	
	String chat_tmp;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Square window = new Square();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Square() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(1200, 1200/12*9));
		frame.setSize(1200,1200/12*9);
		frame.setLocationRelativeTo(null);
		frame.setTitle("�������");
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//////////////////////////////////////////////////////
		/////////////////////////////ä�� �г�
		JPanel chatting = new JPanel();
		chatting.setBackground(UIManager.getColor("Button.background"));
		chatting.setBounds(0, 0, 825, 860);
		frame.getContentPane().add(chatting);
		chatting.setLayout(null);
		
		//	ä���� ���̴� ����
		JTextArea output = new JTextArea();
		
		output.setFont(new Font("MD����ü", Font.PLAIN, 20));
		output.setBounds(30, 30, 760, 750);
		output.setBackground(Color.WHITE);
		output.setEditable(false);
		chatting.add(output);
		
		//ä���� �Է��ϴ� ĭ
		JTextField input = new JTextField(20);
		input.setBounds(30, 805, 675, 35);
		input.setText("ä���� �Է��ϼ���");
		chatting.add(input);
		
		//�Է� ��ư
		JButton input_btn = new JButton("�Է�");
		input_btn.setSize(76, 40);
		input_btn.setLocation(717, 802);
		input_btn.setBackground(Color.LIGHT_GRAY);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chat_tmp = input.getText();
				LocalTime now = LocalTime.now();
				output.append(" >>> "+chat_tmp+"     "+now.getHour()+":"+now.getMinute()+":"+now.getSecond()+"\n");
				input.setText("");
				input.requestFocus();
				
			}
		});
		input_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chat_tmp = input.getText();
				LocalTime now = LocalTime.now();
				output.append(" >>> "+chat_tmp+"     "+now.getHour()+":"+now.getMinute()+":"+now.getSecond()+"\n");
				input.setText("");
				input.requestFocus();
				
			}
		});
		chatting.add(input_btn);
		
		
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////
		////////////////// ���� �г�
		JPanel room_list = new JPanel();
		room_list.setBackground(UIManager.getColor("Button.background"));
		room_list.setBounds(825, 37, 359, 520);
		frame.getContentPane().add(room_list);
		room_list.setLayout(null);
			//���� ��ư
			JButton users_btn = new JButton("USERS");
			users_btn.setBackground(Color.GRAY);
			users_btn.setFont(new Font("����", Font.BOLD, 18));
			users_btn.setBounds(185, 24, 145, 50);
			users_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			room_list.add(users_btn);
			//���ӹ� ��ư
			JButton room_btn = new JButton("ROOM");
			room_btn.setBackground(Color.LIGHT_GRAY);
			room_btn.setFont(new Font("����", Font.BOLD, 18));
			room_btn.setLocation(41, 24);
			room_btn.setSize(145, 50);
			room_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			room_list.add(room_btn);
	

			////////////////////////////////////////////////
			///////////������� �г�
			JPanel users_list = new JPanel(); 
			users_list.setBackground(Color.LIGHT_GRAY);
			users_list.setBounds(41, 72, 289, 400);
			room_list.add(users_list);
			users_list.setLayout(null);
			users_list.setVisible(false);
			users_list.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			////////////////////////////////////////////////
			///////////���ӹ� �г�
			JPanel rooms_list = new JPanel(); 
			rooms_list.setBackground(Color.LIGHT_GRAY);
			rooms_list.setBounds(41, 72, 289, 400);
			room_list.add(rooms_list);
			rooms_list.setLayout(null);
			rooms_list.setVisible(true);
			rooms_list.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			int room1_tmp=0;
			JButton room1 = new JButton("ROOM 1"+"              "+room1_tmp+" / 2");
			room1.setBounds(24, 30, 240, 35);
			rooms_list.add(room1);
			room1.setFont(new Font("����", Font.BOLD, 15));
			room1.setBackground(Color.LIGHT_GRAY);
			
			room1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (room1_tmp==2) {
						JOptionPane.showMessageDialog(null,"�濡 ������ �� �����ϴ�.");
					}
				}
			});
			
			int room2_tmp=0;
			JButton room2 = new JButton("ROOM 2"+"              "+room2_tmp+" / 2");
			room2.setBackground(Color.LIGHT_GRAY);
			room2.setFont(new Font("����", Font.BOLD, 15));
			room2.setBounds(24, 85, 240, 35);
			rooms_list.add(room2);
			
			room2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (room2_tmp==2) {
						JOptionPane.showMessageDialog(null,"�濡 ������ �� �����ϴ�.");
					}
				}
			});
			
			int room3_tmp=0;
			JButton room3 = new JButton("ROOM 3"+"              "+room3_tmp+" / 2");
			room3.setFont(new Font("����", Font.BOLD, 15));
			room3.setBounds(24, 140, 240, 35);
			room3.setBackground(Color.LIGHT_GRAY);
			rooms_list.add(room3);
			
			room3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (room3_tmp==2) {
						JOptionPane.showMessageDialog(null,"�濡 ������ �� �����ϴ�.");
					}
				}
			});
			
			
			
			int room4_tmp=2;
			JButton room4 = new JButton("ROOM 4"+"              "+room4_tmp+" / 2");
			room4.setFont(new Font("����", Font.BOLD, 15));
			room4.setBounds(24, 195, 240, 35);
			
			room4.setBackground(Color.LIGHT_GRAY);
			rooms_list.add(room4);
			
			room4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (room4_tmp==2) {
						JOptionPane.showMessageDialog(null,"�濡 ������ �� �����ϴ�.");
					}
				}
			});
		
		
		//////////////////////////////////////////////
		/////////������ �г�/////////////////////////////
		//////////////////////////////////////////////
		JPanel user_info = new JPanel(); 
		user_info.setBounds(866, 556, 289, 280);
		user_info.setLayout(null);
		user_info.setBorder((new LineBorder(Color.LIGHT_GRAY,4)));
		frame.getContentPane().add(user_info);
			//���� Ÿ��Ʋ
			JTextField info_title = new JTextField("User info");
			info_title.setEditable(false);
			info_title.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			info_title.setHorizontalAlignment(SwingConstants.CENTER);
			info_title.setFont(new Font("����", Font.BOLD, 20));
			info_title.setBounds(12, 37, 157, 29);
			user_info.add(info_title);
			//���� ���̵�
			JTextField info_ID = new JTextField("ID : ");
			info_ID.setEditable(false);
			info_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			info_ID.setFont(new Font("����", Font.BOLD, 20));
			info_ID.setBounds(49, 101, 157, 29);
			user_info.add(info_ID);
			//���� �г���
			JTextField info_NIC = new JTextField("Player~~~");
			info_NIC.setEditable(false);
			info_NIC.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			info_NIC.setFont(new Font("����", Font.BOLD, 20));
			info_NIC.setBounds(49, 140, 157, 29);
			user_info.add(info_NIC);
			//����
			JTextField info_WIN = new JTextField("WIN : ");
			info_WIN.setEditable(false);
			info_WIN.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			info_WIN.setFont(new Font("����", Font.BOLD, 20));
			info_WIN.setBounds(49, 179, 157, 29);
			user_info.add(info_WIN);
			//������
			JButton more = new JButton("more ->");
			more.setForeground(Color.BLUE);
			more.setBackground(new Color(240,240,240));
			more.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 13));
			more.setBounds(181, 213, 80, 25);
			more.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			user_info.add(more);
			more.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
	
			
			
	//���ӹ� ��ư����
		room_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room_btn.setBackground(Color.LIGHT_GRAY);
				users_btn.setBackground(Color.GRAY);
				rooms_list.setVisible(true);
				users_list.setVisible(false);

				}
			});
		
	//������ ��ư����
		users_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users_btn.setBackground(Color.LIGHT_GRAY);
				room_btn.setBackground(Color.GRAY);
				rooms_list.setVisible(false);
				users_list.setVisible(true);
			}
		});
	}
}