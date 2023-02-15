package UserPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HomeScreenBackup01 extends JFrame implements ActionListener {

	private JFrame frame;
	private JButton b1, b2, b3, b4, b5, b6, b7, b0;
	private JScrollPane scrollPane;
	private ImageIcon icon;

	public HomeScreenBackup01() {
		icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\img\\eng.JPG");
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};

		frame = new JFrame("Home Screen");
//		frame.setLayout(new FlowLayout());
		frame.setLayout(null);
		frame.setSize(1050, 1200);

		ScrollPane sp = new ScrollPane();
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);

		b0 = new JButton("[개asd]");
		b0.setBounds(560, 760, 400, 200);
		b0.setFont(new Font("Gothic", Font.BOLD, 25));

		// b3.setSize(100, 80);
		b0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});

//----------------------------------b1---------------------------------------------------------------
		b1 = new JButton("[토익] - TOEIC");
		// b1.setSize(100, 80);
		b1.setBounds(60, 60, 400, 180);
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
		b2.setBounds(560, 60, 400, 180);
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
		b3.setBounds(560, 260, 400, 180);
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

		b6 = new JButton("[질문 기능] \n Chat with association");
		b6.setBounds(60, 760, 400, 210);
		b6.setFont(new Font("Gothic", Font.BOLD, 20));

		// b5.setSize(100, 80);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new ToeicOptions();
				// new ClientGui();
				// f5.setVisible(true);

//				frame.setVisible(false);

			}
		});

		/*
		 * b7 = new JButton("[愿�由ъ옄 �럹�씠吏� /臾몄젣 諛� �떒�뼱 �젣異� ] \n Admin Page");
		 * b7.setBounds(600, 760, 400, 210); b7.setFont(new Font("Gothic", Font.BOLD,
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
		frame.add(b0);
		frame.add(b6);
		// frame.add(b3);
		// frame.add(b4);
		// frame.add(b7);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		HomeScreenBackup01 ff = new HomeScreenBackup01();

		ff.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(true);

	}
}
