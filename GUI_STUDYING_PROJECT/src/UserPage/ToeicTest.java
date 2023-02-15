package UserPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

 

 

 

class ToeicTest extends JFrame implements ActionListener {

	JFrame frame = new JFrame("ToeicTest");

	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2, b3;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[5];

	ToeicTest(String s) {
		super(s);
		l = new JLabel();
		add(l);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1 = new JButton("다음");
		b2 = new JButton("패스");
		b3 = new JButton("HomeScreen으로 돌아가기");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		add(b1);
		add(b2);
		add(b3);

		set();
		l.setBounds(30, 40, 450, 20);
		jb[0].setBounds(50, 80, 450, 20);
		jb[1].setBounds(50, 110, 450, 20);
		jb[2].setBounds(50, 140, 450, 20);
		jb[3].setBounds(50, 170, 450, 20);
		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);
		b3.setBounds(480, 240, 100, 30);

		b3.setVisible(true);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				hs.startFrame();
				frame.setVisible(false);

			}

		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
//		setLocation(250, 100);
		setVisible(true);
		setSize(1200, 1200);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 4) {
				b1.setEnabled(false);
				b2.setText("결과");
			}
		}
		if (e.getActionCommand().equals("패스")) {
			JButton bk = new JButton("패스" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 4)
				b2.setText("결과");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("패스" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("결과")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "정답수=" + count);
			System.exit(0);
		}
	}

	void set() {
		jb[4].setSelected(true);
		if (current == 0) {
			l.setText("1.First thing you have to do when you get home is ");
			jb[0].setText("① take shit.");
			jb[1].setText("② take off your clothes");
			jb[2].setText("③ wash yourself");
			jb[3].setText("④ Feb bitch");

		}
		if (current == 1) {
			l.setText("2.Blahblahgblah");
			jb[0].setText("① public");
			jb[1].setText("② private");
			jb[2].setText("③ abstract");
			jb[3].setText("④ final");
		}
		if (current == 2) {
			l.setText("3. A to the Z has 29 alphabet ");
			jb[0].setText("① real to rare is close");
			jb[1].setText("② taking shit and poop is same");
			jb[2].setText("③ counting number has numerical formular");
			jb[3].setText("④ five categories starts with first category");
		}
		if (current == 3) {
			l.setText("4. 다음 코드 중 런타임 오류가 발생하는 것은.");
			jb[0].setText("①int a = 3.5; ");
			jb[1].setText("②int a1 = 5; double a2 = (float)a1;");
			jb[2].setText("③int a = 9 / 0; ");
			jb[3].setText("④float a = Integer.parseInt('30');");
		}
		if (current == 4) {
			l.setText("5.eeeeeeeeeeee.");
			jb[0].setText("① aaaaaaaaa.");
			jb[1].setText("② bbbbbbbbb.");
			jb[2].setText("③ ccccccccc.");
			jb[3].setText("⑤ ddddddddd.");
		}

		l.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			jb[j].setBounds(50, 80 + i, 400, 20);
	}

	boolean check() {//답은 jb[2]한부분으로 2,3,1,2,0 즉 3,4,2,3,1,
		if (current == 0)
			return (jb[2].isSelected());
		if (current == 1)
			return (jb[3].isSelected());
		if (current == 2)
			return (jb[1].isSelected());
		if (current == 3)
			return (jb[2].isSelected());
		if (current == 4)
			return (jb[0].isSelected());
		return false;
	}
}