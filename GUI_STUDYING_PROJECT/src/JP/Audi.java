package JP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Audi extends WindowAdapter implements ActionListener {
	private JFrame frame;
	private int index;
	private JTextArea Area = new JTextArea();

	private String[] images = { "image/etron.png", "image/etronsport.png", "image/etrons.png", "image/etrons2.png",
			"image/etronGT.png", "image/rsetronGT.png", "image/Q4.png" };

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Audi AD = new Audi();
					AD.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// 메인메소드 끝

	public Audi() {

		AudiF();
		Connection conn = new DBConnection_maria().getConnection();

		ArrayList<CarDTO> list = new ArrayList<CarDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DBConnection_maria.getConnection();

			StringBuffer sql = new StringBuffer();

			sql.append(
					"select NO, BRAND, MODEL, PRICE, TYPE, BCAPACITY, POWER, MILEAGE, MAXDISTANCE from CAR where Brand = 'Audi' ");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery(); // 쿼리 실행
			while (rs.next()) {
				int index = 1;
				int No = rs.getInt(index++);
				String Brand = rs.getString(index++);
				String Model = rs.getString(index++);
				String Price = rs.getString(index++);
				String Type = rs.getString(index++);
				String Bcapacity = rs.getString(index++);
				String Power = rs.getString(index++);
				String Mileage = rs.getString(index++);
				String Maxdistance = rs.getString(index++);

				list.add(new CarDTO(No, Brand, Model, Price, Type, Bcapacity, Power, Mileage, Maxdistance));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		for (CarDTO setbtnChoice : list) {

			System.out.println("넘버: " + setbtnChoice.getNo() + "  모델: " + setbtnChoice.getModel() + "  가격:"
					+ setbtnChoice.getPrice() + "  차량종류: " + setbtnChoice.getType());
		}

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void AudiF() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 800);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);
		getFrame().setResizable(false);

		Font font = new Font("굴림", Font.BOLD, 48);

		JLabel lblImage = new JLabel();
		lblImage.setBounds(0, 0, 980, 370);

		Area = new JTextArea();
		Area.setBounds(15, 400, 800, 240);
		getFrame().add(Area);

		lblImage.setIcon(new ImageIcon(images[getIndex()])); // index 처음 0, IMAGES[0] 랑 결과 같음
		getFrame().getContentPane().add(lblImage);

// frame 안에 이미지추가

		JButton btnPrev = new JButton("←");
		btnPrev.setBackground(Color.CYAN);
		btnPrev.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (getIndex() > 0) { // 현재 인덱스가 0보다 크면
					setIndex(getIndex() - 1); // 인덱스를 감소
				} else { // 현재 인덱스가 0이면
					setIndex(images.length - 1); // 배열의 가장 큰 인덱스 번호로 변경
				}
				lblImage.setIcon(new ImageIcon(images[getIndex()])); // 버튼 누를때마다 다음 이미지로 이동
			}

		});
		btnPrev.setFont(font);
		btnPrev.setBounds(10, 665, 200, 80);
		getFrame().getContentPane().add(btnPrev);

		JButton btnChoice = new JButton("상세정보");
		btnChoice.setBackground(Color.lightGray);
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		btnChoice.setFont(font);
		btnChoice.setBounds(250, 665, 280, 80);
		getFrame().getContentPane().add(btnChoice);

		JButton btnNext = new JButton("→");
		btnNext.setBackground(Color.CYAN);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getIndex() < images.length - 1) { // 마지막 인덱스보다 작은 경우
					setIndex(getIndex() + 1); // 인덱스 증가
				} else { // 현 인덱스가 문자열의 길이가 -1이 되는 경우
					setIndex(0); // 인덱스를 0으로 초기화(0번으로 변경)
				}
				lblImage.setIcon(new ImageIcon(images[getIndex()]));

			}

		});
		btnNext.setFont(font);
		btnNext.setBounds(570, 665, 200, 80);
		getFrame().getContentPane().add(btnNext);

	} // AudiF 메소드 끝

	public class DBConnection_maria {
		private static final String driver = "oracle.jdbc.driver.OracleDriver";
		private static final String url = "jdbc:oracle:thin:@localhost:1521/xe";
		private static final String user = "c##green";
		private static final String pwd = "GREEN1234";

		Connection con = null;
		Statement stmt = null;

		ResultSet rs = null;
		try
		{
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = con.createStatement();

			String sql2 = "SELECT BRAND  FROM CAR";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("BRAND") + "\t");

				Area.setText(rs2.getString("BRAND"));

			}
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}

	}
	// -----------

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

} // Audi 클래스 끝
