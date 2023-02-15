package UserPage;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class back extends JFrame {
	JScrollPane scrollPane;
	ImageIcon icon;
	JFrame frame;

	public back() {
		icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\img\\eng.JPG");

		// 배경 Panel 생성후 컨텐츠페인으로 지정
	 
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);

			}
		};
 
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
	}

	public static void main(String[] args) {
		back frame = new back();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}