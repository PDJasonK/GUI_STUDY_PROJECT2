package A1111.LogMain;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;

import AdminOptionPage.AdminOptionPage;
import LogData.LoginDAO;
import UserPage.HomeScreen;

public class LoginMain extends WindowAdapter implements ActionListener {
	private Frame f;
	private Frame suf;
	private Frame faf;
	private Label lid;
	private Label lpwd;
	private Panel p;
	private Panel p2;

	private TextField id;
	private TextField pwd;

	private Label lsulog;
	private JButton ToMain;
	private JButton CheckProfile;

	private Button falog;
	private Button log;
	private Button signup;
	private Button BackToLogin;

	private JTextArea FailText;
	AdminOptionPage AP = new AdminOptionPage();

//*------------------------------------------------------------
	public LoginMain() {
		// 濡쒓렇�씤 �솕硫�
		f = new Frame("Login");
		f.setSize(300, 150);
		f.setBackground(Color.white);

		// 濡쒓렇�씤 �꽦怨� �솕硫�
		suf = new Frame("濡쒓렇�씤 �꽦怨�");
		suf.setFont(new Font("Gothic", Font.BOLD, 20));
		suf.setSize(550, 100);

		faf = new Frame("濡쒓렇�씤 �떎�뙣");
		faf.setLayout(null);
		faf.setSize(450, 150);
		faf.setBackground(Color.gray);

		FailText = new JTextArea("鍮꾨�踰덊샇媛� ���졇�뒿�땲�떎. " + "\n濡쒓렇�씤�쓣 �떎�떆 �떆�룄�븯�꽭�슂.");
//		FailText.setLayout(null);
		FailText.setBounds(20, 50, 160, 40);
		FailText.setVisible(true);
		faf.add(FailText);

		BackToLogin = new Button("濡쒓렇�씤 李쎌쑝濡� �룎�븘媛�湲�");
		BackToLogin.setBounds(250, 50, 180, 30);
		BackToLogin.setBackground(Color.yellow);
		BackToLogin.setFont(new Font("Gothic", Font.BOLD, 10));
		faf.add(BackToLogin);
		BackToLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				faf.setVisible(false);
				LoginMain lg = new LoginMain();
				lg.startframe();
			}

		});

		p = new Panel();
		p2 = new Panel();
		lid = new Label("�븘�씠�뵒 : ", Label.CENTER);
		lpwd = new Label("鍮꾨�踰덊샇: ", Label.CENTER);

		id = new TextField(20);
		pwd = new TextField(20);
		log = new Button("濡쒓렇�씤");
		log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				faf.setVisible(false);

			}

		});

		signup = new Button("�쉶�썝媛��엯");

		lsulog = new Label("濡쒓렇�씤 �꽦怨�");

		ToMain = new JButton("硫붿씤 �솕硫댁쑝濡� �꽆�뼱媛�湲�");
		ToMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				ToMain.setVisible(true);

				hs.startFrame();

			}

		});
		CheckProfile = new JButton("媛쒖씤�젙蹂� �솗�씤");
//		CheckProfile.setBackground(Color.gray);
		CheckProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginChecker LG = new LoginChecker(id.getText());

			}

		});
	}

	public void startframe() {

		f.add(p, "Center");
		f.addWindowListener(this);
		log.addActionListener(this);
		signup.addActionListener(this);
		suf.addWindowListener(this);
		faf.addWindowListener(this);

		ToMain.addActionListener(this);
		CheckProfile.addActionListener(this);
		pwd.setEchoChar('*');

		suf.add(p2, "Center");
		p2.add(lsulog);
		p2.add(ToMain);
		p2.add(CheckProfile);

		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(log);
		p.add(signup);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == log) {
			LoginDAO dao = new LoginDAO();

			int daoidcheck = dao.logincheck(id.getText());
			int daoid = dao.login(id.getText(), pwd.getText());
			System.out.println(id.getText());
			System.out.println(pwd.getText());
			System.out.println(daoidcheck);
			System.out.println(daoid);
			if (daoidcheck == 1) {
				if (daoid == 1) {
					f.dispose();
					// AP.AdminOptionPage();
				}
			} else {
				if (daoid == 1) {
					f.dispose();
					new HomeScreen();
				}
			}

//			ArrayList<LoginVo> list = dao.list(id.getText(), pwd.getText());
//			for (int i = 0; i < list.size(); i++) {
//				LoginVo data = (LoginVo) list.get(i);
//				myid = data.getId();
//				mypwd = data.getPwd();
//			}
//			System.out.println(myid);
//			System.out.println(mypwd);
//
//			if (id.getText().equals(myid) && pwd.getText().equals(mypwd)) {
//				suf.setVisible(true);
//			} else {
//				faf.setVisible(true);
//				f.setVisible(false);
//			}
		}

		// if (e.getActionCommand().equals("�쉶�썝媛��엯")) {
		if (signup.equals(e.getSource())) {
			Signup sg = new Signup();
			sg.startframe();
			f.setVisible(false);
		}

		if (ToMain.equals(e.getSource())) {
			suf.setVisible(false);
			f.setVisible(false);
		}

		if (CheckProfile.equals(e.getSource())) {
			suf.setVisible(false);
			f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		LoginMain lg = new LoginMain();
		lg.startframe();
	}
}