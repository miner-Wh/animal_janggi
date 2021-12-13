import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.*;
import java.util.ArrayList;

public class Login {
	ClientChatter chatter = new ClientChatter();
	boolean check1 =false;
	private JFrame frame;
	private JTextField txtCreateID;
	private JTextField txtName;
	private JTextField txtCreatepassword;
	private JTextField txtNickName;
	private JTextField txtSNS;
	private JTextField txtMail;
	public String ids;
	public String pws;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		chatter.login();
//		chatter.ready();


		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(1200, 1200/12*9));
		frame.setSize(1200,1200/12*9);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("십이장기");
		frame.getContentPane().setLayout(null);
		//////////////////////////////////////////////////////////////////////////
		////////////로그인 패널 /////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		JPanel Loginpage = new JPanel();
		frame.getContentPane().add(Loginpage);
		Loginpage.setLayout(null);
		Loginpage.setBackground(new Color(220, 220, 220));
		Loginpage.setBounds(312, 97, 559, 666);

		JButton logbtn = new JButton("LOGIN");
		logbtn.setForeground(SystemColor.window);
		logbtn.setBackground(SystemColor.activeCaption);
		JLabel ID = new JLabel("ID");
		JLabel title = new JLabel("十二將棋");
		JTextField txtID = new JTextField(20);
		JLabel password = new JLabel("Password");
		JPasswordField txtpassword = new JPasswordField(20);
		JButton accountbtn = new JButton("Crate account");

		//////////////////////////////////////////////////////////////////////////
		////////////계정 생성창/////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		JPanel Accountpage = new JPanel();
		Accountpage.setBackground(new Color(220, 220, 220));
		Accountpage.setBounds(312, 97, 559, 666);
		frame.getContentPane().add(Accountpage);
		Accountpage.setLayout(null);
		Accountpage.setVisible(false);

		JLabel CreateID = new JLabel("ID");
		CreateID.setHorizontalAlignment(SwingConstants.CENTER);
		CreateID.setFont(new Font("굴림", Font.PLAIN, 17));
		CreateID.setBounds(123, 129, 97, 23);
		Accountpage.add(CreateID);

		txtCreateID = new JTextField(20);
		txtCreateID.setBounds(218, 129, 208, 23);
		Accountpage.add(txtCreateID);

		JButton back_login = new JButton("BACK");
		back_login.setForeground(Color.BLUE);
		back_login.setBackground(Color.LIGHT_GRAY);
		back_login.setBounds(218, 532, 123, 16);
		Accountpage.add(back_login);
		JButton createbtn = new JButton("Create");
		createbtn.setForeground(SystemColor.window);
		createbtn.setBackground(SystemColor.activeCaption);
		createbtn.setFont(new Font("CentSchbook BT", Font.PLAIN, 26));
		createbtn.setBounds(205, 475, 149, 54);
		Accountpage.add(createbtn);

		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setFont(new Font("굴림", Font.PLAIN, 17));
		Name.setBounds(123, 79, 97, 23);
		Accountpage.add(Name);

		txtName = new JTextField(20);
		txtName.setBounds(218, 79, 208, 23);
		Accountpage.add(txtName);

		JLabel Createpassword = new JLabel("Password");
		Createpassword.setHorizontalAlignment(SwingConstants.CENTER);
		Createpassword.setFont(new Font("굴림", Font.PLAIN, 17));
		Createpassword.setBounds(123, 230, 97, 23);
		Accountpage.add(Createpassword);

		txtCreatepassword = new JTextField(20);
		txtCreatepassword.setBounds(218, 230, 208, 23);
		Accountpage.add(txtCreatepassword);

		JLabel NickName = new JLabel("NickName");
		NickName.setHorizontalAlignment(SwingConstants.CENTER);
		NickName.setFont(new Font("굴림", Font.PLAIN, 17));
		NickName.setBounds(123, 275, 97, 23);
		Accountpage.add(NickName);

		txtNickName = new JTextField(20);
		txtNickName.setBounds(218, 276, 208, 23);
		Accountpage.add(txtNickName);

		JLabel SNS = new JLabel("SNS");
		SNS.setHorizontalAlignment(SwingConstants.CENTER);
		SNS.setFont(new Font("굴림", Font.PLAIN, 17));
		SNS.setBounds(123, 375, 97, 23);
		Accountpage.add(SNS);

		txtSNS = new JTextField(20);
		txtSNS.setBounds(218, 376, 208, 23);
		Accountpage.add(txtSNS);

		JLabel Mail = new JLabel("E-MAIL");
		Mail.setHorizontalAlignment(SwingConstants.CENTER);
		Mail.setFont(new Font("굴림", Font.PLAIN, 17));
		Mail.setBounds(123, 328, 97, 23);
		Accountpage.add(Mail);

		txtMail = new JTextField(20);
		txtMail.setBounds(218, 328, 208, 23);
		Accountpage.add(txtMail);

		JButton duplicatebtn = new JButton("duplicate");
		duplicatebtn.setBackground(new Color(135, 206, 250));
		duplicatebtn.setBounds(105, 172, 115, 23);
		Accountpage.add(duplicatebtn);

		JLabel check = new JLabel("");
		check.setForeground(new Color(255, 0, 0));
		check.setHorizontalAlignment(SwingConstants.CENTER);
		check.setBounds(232, 176, 180, 15);
		Accountpage.add(check);
		Accountpage.setVisible(false);


		//계정 생성버튼 CREATE
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//생성된 계정 정보
				String new_id = txtCreateID.getText();
				String new_name = txtName.getText();
				String new_password = txtCreatepassword.getText();
				String new_sns = txtSNS.getText();
				String new_mail = txtMail.getText();
				String new_nickname = txtNickName.getText();
				if(check1) {

					int get =0;

					try {
						get = chatter.sendMSG("sign/6"+"/"+new_id+"/"+new_password+"/"+new_name+"/"+new_nickname+"/"+new_mail+"/"+new_sns);
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					if(get ==1){
						JOptionPane.showMessageDialog(null,"계정이 생성되었습니다.");

						Accountpage.setVisible(false);
						Loginpage.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null,"아이디 중복확인을 해주세요");
					}

				}
				else {
					JOptionPane.showMessageDialog(null,"아이디 중복확인을 해주세요");
				}

			}
		});
		//로그인창 돌아가기
		back_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accountpage.setVisible(false);
				Loginpage.setVisible(true);

			}
		});
		//중복확인 버튼
		duplicatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int get=0;

				try {
					get = chatter.sendMSG("dup/1/"+txtCreateID.getText());
				} catch (IOException ex) {
					ex.printStackTrace();
				}


				if(get==1) {
					check.setText("사용 불가능한 ID입니다.");
					check1=false;
				}else{
					check.setText("사용 가능한 ID입니다.");
					check1=true;
				}

			}
		});














		logbtn.setFont(new Font("CentSchbook BT", Font.PLAIN, 26));
		title.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 57));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("굴림", Font.PLAIN, 17));
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("굴림", Font.PLAIN, 17));
		password.setHorizontalAlignment(SwingConstants.CENTER);


		title.setBounds(138,133,283,165);
		txtID.setBounds(218, 342, 208, 23);
		logbtn.setBounds(205, 475, 149, 54);
		ID.setBounds(123, 342, 97, 23);
		txtpassword.setBounds(218, 386, 208, 23);
		password.setBounds(123, 386, 97, 23);
		accountbtn.setBackground(Color.LIGHT_GRAY);
		accountbtn.setForeground(Color.BLUE);
		accountbtn.setBounds(218, 532, 123, 16);


		Loginpage.add(ID);
		Loginpage.add(txtID);
		Loginpage.add(password);
		Loginpage.add(txtpassword);
		Loginpage.add(logbtn);
		Loginpage.add(title);
		Loginpage.add(accountbtn);


		//LOGIN 버튼
		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int get=0;
				//System.out.println("전전");
				try {
					get = chatter.sendMSG("log/2/"+txtID.getText()+"/"+txtpassword.getText());
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				//System.out.println("전");
				System.out.println(get);
				//System.out.println("후");

				if(get==1) {
					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
				}
				else if(get==2) {
					JOptionPane.showMessageDialog(null,"없는 계정 입니다.");
				}
				else if(get==3) {
					JOptionPane.showMessageDialog(null,"아이디와 비번이 맞지 않습니다.");
				}

			}
		});
		//계정 생성창 버튼
		accountbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accountpage.setVisible(true);
				Loginpage.setVisible(false);

			}
		});




		////////로그인 접속 작동


		logbtn.setFont(new Font("CentSchbook BT", Font.PLAIN, 26));
		title.setFont(new Font("한컴 윤고딕 240", Font.BOLD, 57));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("굴림", Font.PLAIN, 17));
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("굴림", Font.PLAIN, 17));
		password.setHorizontalAlignment(SwingConstants.CENTER);


		title.setBounds(138,133,283,165);
		txtID.setBounds(218, 342, 208, 23);
		logbtn.setBounds(205, 475, 149, 54);
		ID.setBounds(123, 342, 97, 23);
		txtpassword.setBounds(218, 386, 208, 23);
		password.setBounds(123, 386, 97, 23);
		accountbtn.setBackground(Color.LIGHT_GRAY);
		accountbtn.setForeground(Color.BLUE);
		accountbtn.setBounds(218, 532, 123, 16);


		Loginpage.add(ID);
		Loginpage.add(txtID);
		Loginpage.add(password);
		Loginpage.add(txtpassword);
		Loginpage.add(logbtn);
		Loginpage.add(title);
		Loginpage.add(accountbtn);


		//LOGIN 버튼
		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int get=0;
				ids = txtID.getText();
				pws = txtpassword.getText();

				try {
					get = chatter.sendMSG("log/2/"+ids+"/"+pws);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				if(get==1) {
					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");



					frame.setVisible(false);
					new Square();

				}
				else if(get==2) {
					JOptionPane.showMessageDialog(null,"없는 계정 입니다.");
				}
				else if(get==3) {
					JOptionPane.showMessageDialog(null,"아이디와 비번이 맞지 않습니다.");
				}

			}
		});
//		//LOGIN 버튼
//		txtID.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int get=0;
//				try {
//					get = chatter.sendMSG("log/2/"+txtID.getText()+"/"+txtpassword.getText());
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
//
//				if(get==1) {
//					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
//					frame.setVisible(false);
//					new Square();
//				}
//				else if(get==2) {
//					JOptionPane.showMessageDialog(null,"없는 계정 입니다.");
//				}
//				else if(get==3) {
//					JOptionPane.showMessageDialog(null,"아이디와 비번이 맞지 않습니다.");
//				}
//
//			}
//		});
//		//LOGIN 버튼
//		txtpassword.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int get=0;
//				try {
//					get = chatter.sendMSG("log/2/"+txtID.getText()+"/"+txtpassword.getText());
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
//
//				if(get==1) {
//					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
//					frame.setVisible(false);
//					new Square();
//				}
//				else if(get==2) {
//					JOptionPane.showMessageDialog(null,"없는 계정 입니다.");
//				}
//				else if(get==3) {
//					JOptionPane.showMessageDialog(null,"아이디와 비번이 맞지 않습니다.");
//				}
//
//			}
//		});
		//계정 생성창 버튼
		accountbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accountpage.setVisible(true);
				Loginpage.setVisible(false);

			}
		});






	}
}