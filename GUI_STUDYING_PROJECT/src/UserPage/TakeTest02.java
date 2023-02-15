package UserPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class TakeTest02 extends JFrame implements ActionListener {
	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[5];

	TakeTest02(String s) {
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
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		set();
		l.setBounds(30, 40, 450, 20);
		jb[0].setBounds(50, 80, 450, 20);
		jb[1].setBounds(50, 110, 450, 20);
		jb[2].setBounds(50, 140, 450, 20);
		jb[3].setBounds(50, 170, 450, 20);
		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 400);
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
			l.setText("1.자바 데이터 타입에 대한 설명 중 틀린 것을 고르시오. ");
			jb[0].setText("① String 타입은 객체형이다.");
			jb[1].setText("② char 타입 변수는 2 byte의 메모리 공간을 사용한다.");
			jb[2].setText("③ Boolean 타입 변수는 1 byte의 메모리 공간을 차지한다");
			jb[3].setText("④ int 타입 변수는 4 byte의 메모리 공간을 사용한다. ");

		}
		if (current == 1) {
			l.setText("2. ___ class ATestClass {  에 들어갈 수 없는 키워드를 고르시오.");
			jb[0].setText("① public");
			jb[1].setText("② private");
			jb[2].setText("③ abstract");
			jb[3].setText("④ final");
		}
		if (current == 2) {
			l.setText("3.자바에서 메소드 오버로딩에 대한 설명으로 틀린 것은? ");
			jb[0].setText("① 동일클래스내에서 발생한다.");
			jb[1].setText("② 매개변수의 형은 동일해야 한다.");
			jb[2].setText("③ 다형성을 지원하기위한 장치이다.");
			jb[3].setText("④ 메소드이름이 동일해야 한다.");
		}
		if (current == 3) {
			l.setText("4. 다음 코드 중 런타임 오류가 발생하는 것은.");
			jb[0].setText("①int a = 3.5; ");
			jb[1].setText("②int a1 = 5; double a2 = (float)a1;");
			jb[2].setText("③int a = 9 / 0; ");
			jb[3].setText("④float a = Integer.parseInt('30');");
		}
		if (current == 4) {
			l.setText("5.다음 설명 중 틀린 것을 고르시오.");
			jb[0].setText("① 추상 클래스는 하나 이상의 추상 메소드를 포함하고 있어야 한다.");
			jb[1].setText("② 추상 클래스는 객체를 생성할 수 없다.");
			jb[2].setText("③ protected 메소드는 모든 하위 클래스에서 호출할 수 있다.");
			jb[3].setText("⑤ 자바의 모든 클래스는 Object 클래스의 자식 클래스이다.");
		}

		l.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			jb[j].setBounds(50, 80 + i, 400, 20);
	}

	boolean check() {
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

	public static void main(String s[]) {
		new TakeTest01("자바 온라인 시험");
	}
}