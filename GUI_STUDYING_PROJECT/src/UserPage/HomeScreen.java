package UserPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import LogMain.SignupChecker;
import QuestionBoard.QuestionSubmitBoard01;

public class HomeScreen implements ActionListener {

	private JFrame f1, f2, f3, f4, f5, frame;
	private JButton b1, b2, b3, b4, b5, b6, b7, b0;
	private JLabel lb1, lb2, lb3;

	public HomeScreen() {
		frame = new JFrame("Home Screen");
//		frame.setLayout(new FlowLayout());
		frame.setLayout(null);
		frame.setSize(1050, 1200);

		ScrollPane sp = new ScrollPane();
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);

		b0 = new JButton("[개인정보 확인]");
		b0.setBounds(560, 850, 400, 100);
		b0.setFont(new Font("Gothic", Font.BOLD, 25));

		// b3.setSize(100, 80);
		b0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SignupChecker();

			}

		});

//----------------------------------b1---------------------------------------------------------------
		b1 = new JButton("[토익] - TOEIC");
		// b1.setSize(100, 80);
		b1.setBounds(60, 60, 400, 100);
		b1.setFont(new Font("Gothic", Font.BOLD, 30));

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// f1.setVisible(true);
				// new Instruction();
				frame.setVisible(false);
				new ToeicOptions();
			}
		});
//------------------------------------b2-------------------------------------------------------------
		b2 = new JButton("[토플] - TOEFL");
		b2.setBounds(560, 60, 400, 100);
		b2.setFont(new Font("Gothic", Font.BOLD, 30));
		// b2.setSize(100, 80);
		// b2.addActionListener(this);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				f2.setVisible(true);
				frame.setVisible(false);
				new ToeicOptions();

			}
		});

//--------------------------------------b3-----------------------------------------------------------
		b3 = new JButton("[기본 문법] Grammar");
		b3.setBounds(560, 260, 400, 100);
		b3.setFont(new Font("Gothic", Font.BOLD, 30));

		// b3.setSize(100, 80);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// f3.setVisible(true);
				frame.setVisible(false);
				new ToeicOptions();

			}

		});

//--------------------------------------b4-----------------------------------------------------------

		b4 = new JButton("[湲곕낯�쁺�뼱] - BASIC");
		b4.setBounds(60, 260, 400, 180);
		b4.setFont(new Font("Gothic", Font.BOLD, 30));
		// b4.setSize(100, 80);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				f4.setVisible(true);
				frame.setVisible(false);
				new ToeicOptions();
			}

		});

//--------------------------------------b5-----------------------------------------------------------

		b5 = new JButton("[�꽦�씤�쁺�뼱] - WorkRelated");
		b5.setBounds(300, 500, 400, 200);
		b5.setFont(new Font("Gothic", Font.BOLD, 30));

		// b5.setSize(100, 80);
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new ToeicOptions();

				// QuizSender QS = new QuizSender();
				// QS.startframe();
//				f5.setVisible(true);
				/*
				 * new Speaking(); frame.setVisible(false);
				 */

			}
		});

		b6 = new JButton("[질문 기능] ");
		b6.setBounds(60, 850, 400, 100);
		b6.setFont(new Font("Gothic", Font.BOLD, 20));

		// b5.setSize(100, 80);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new QuestionSubmitBoard01();
				// new ClientGui();
				// f5.setVisible(true);

//				frame.setVisible(false);

			}
		});

		/*
		 * b7 = new JButton("[愿�由ъ옄 �럹�씠吏� /臾몄젣 諛� �떒�뼱 �젣異� ] \n Admin Page");
		 * b7.setBounds(600, 850, 400, 210); b7.setFont(new Font("Gothic", Font.BOLD,
		 * 20));
		 * 
		 * // b5.setSize(100, 80); b7.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { AdminOptionPage AP = new
		 * AdminOptionPage(); AP.startFrame();
		 * 
		 * 
		 * 
		 * } });
		 */
		startFrame();
	}

	public void startFrame() {

		frame.add(b1);
		frame.add(b2);
		// frame.add(b3);
		// frame.add(b4);
		frame.add(b0);

		frame.add(b6);
		// frame.add(b7);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		HomeScreen ff = new HomeScreen();

		ff.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(true);
		f1.setVisible(false);
		f2.setVisible(true);

	}
}
