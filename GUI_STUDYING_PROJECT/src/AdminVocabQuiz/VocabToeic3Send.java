package AdminVocabQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminOptionPage.AdminOptionPage;
import AdminReading.AdminReading1;
import UserPage.HomeScreen;




public class VocabToeic3Send extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
//	private JLabel PContent2;
	//private JLabel PContent3;
	private JLabel title;
	private Statement stmt;
	private Connection conn;
	private JButton Submit,btn1,btn2,btn3 , btn0;


	VocabToeic3SendDAO dao = new VocabToeic3SendDAO();


	/*
	 * public static JTextArea yoyo1 = new JTextArea(); public static JTextArea
	 * yoyo2 = new JTextArea(); public static JTextArea yoyo3 = new JTextArea();
	 */	
	public static JTextArea Input1 = new JTextArea();
	public static JTextArea Input2= new JTextArea();
	public static JTextArea Input3 = new JTextArea();
	public static JTextArea Input4 = new JTextArea();
	public static JTextArea Input5 = new JTextArea();
	public static JTextArea Input6 = new JTextArea();
	public static JTextArea Input7 = new JTextArea();
	public static JTextArea Input8 = new JTextArea();

	// ----------
	public static JTextArea Output1 = new JTextArea();
	public static JTextArea Output2= new JTextArea();
	public static JTextArea Output3 = new JTextArea();
	public static JTextArea Output4= new JTextArea();
	public static JTextArea Output5 = new JTextArea();
	public static JTextArea Output6 = new JTextArea();
	public static JTextArea Output7= new JTextArea();
	public static JTextArea Output8 = new JTextArea();
	public static JTextArea Output9 = new JTextArea();
	public static JTextArea Output10 = new JTextArea();
	public static JTextArea Output11 = new JTextArea();
	public static JTextArea Output12 = new JTextArea();
	public static JTextArea Output13 = new JTextArea();
	public static JTextArea Output14 = new JTextArea();
	public static JTextArea Output15 = new JTextArea();
	public static JTextArea Output16 = new JTextArea();
	/*
	 * public static void main(String[] args) { SubmitMain sm = new SubmitMain();
	 * sm.startframe(); }
	 */
	public VocabToeic3Send() {
		
		f = new JFrame("Voca Moka 3");
		p = new JPanel();
		p.setLayout(null);

		// -----
		

		title = new JLabel("단어 출제 [3] [VocabList] ");
		title.setBounds(30, 1, 800, 50);
		
		Output1.setLayout(null);
		Output1.setBounds(30, 55, 350, 60);
//		Output1.setEditable(false);
		

		Output2.setLayout(null);
		Output2.setBounds(430, 55, 350, 60);
	//	Output2.setEditable(false);
		
		Output3.setLayout(null);
		Output3.setBounds(30, 155, 350, 60);
	//	Output3.setEditable(false);
		
		Output4.setLayout(null);
		Output4.setBounds(430, 155, 350, 60);
		//Output4.setEditable(false);
		
		
		Output5.setLayout(null);
		Output5.setBounds(30, 255, 350, 60);
		//Output5.setEditable(false);
		
		Output6.setLayout(null);
		Output6.setBounds(430, 255, 350, 60);
		//Output6.setEditable(false);
		
		Output7.setLayout(null);
		Output7.setBounds(30, 355, 350, 60);
		//Output7.setEditable(false);
		
		Output8.setLayout(null);
		Output8.setBounds(430, 355, 350, 60);
		//Output8.setEditable(false);
		
		Output9.setLayout(null);
		Output9.setBounds(30, 455, 350, 60);
		//Output8.setEditable(false);
		
		Output10.setLayout(null);
		Output10.setBounds(430, 455, 350, 60);
		//Output8.setEditable(false);
		
		Output11.setLayout(null);
		Output11.setBounds(30, 555, 350, 60);
		//Output8.setEditable(false);
		
		Output12.setLayout(null);
		Output12.setBounds(430, 555, 350, 60);
		//Output8.setEditable(false);
		
		Output13.setLayout(null);
		Output13.setBounds(30, 655, 350, 60);
		//Output8.setEditable(false);
		
		Output14.setLayout(null);
		Output14.setBounds(430, 655, 350, 60);
		//Output8.setEditable(false);
	
		Output15.setLayout(null);
		Output15.setBounds(30, 755, 350, 60);
		//Output8.setEditable(false);
		
		Output16.setLayout(null);
		Output16.setBounds(430, 755, 350, 60);
		//Output8.setEditable(false);
		
		
	//	PContent1 = new JLabel("泥ル쾲吏� 臾몃떒�쓽 �빐�꽍臾�", JLabel.LEFT);
		//PContent1.setBounds(30, 400, 500, 500);
		/*PContent2 = new JLabel("�몢踰덉㎏ 臾몃떒�쓽 �빐�꽍臾�", JLabel.LEFT);
		PContent2.setBounds(30, 380, 500, 500);
		PContent3 = new JLabel("�꽭踰덉㎏ 泥ル쾲吏� 臾몃떒�쓽 �빐�꽍臾� ", JLabel.LEFT);
		PContent3.setBounds(30, 520, 500, 500);

	Input1 = new JTextArea();
		Input1.setBounds(30, 680, 800, 180 );
		Input1.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input1.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input1.setBackground(Color.YELLOW);
		         }
		      });*/
		/*		
		Input2 = new JTextArea();
		Input2.setBounds(30, 640, 50, 90);
		Input2.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input2.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input2.setBackground(Color.YELLOW);
		         }
		      });
		
		Input3 = new JTextArea();
		Input3.setBounds(30, 780, 50, 90);
		Input3.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input3.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input3.setBackground(Color.YELLOW);
		         }
		      });
		
		Input4 = new JTextArea();
		Input4.setBounds(90, 500, 50, 90);
		Input4.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input4.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input4.setBackground(Color.YELLOW);
		         }
		      });
		
		Input5 = new JTextArea();
		Input5.setBounds(90, 640, 50, 90);
		Input5.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input5.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input5.setBackground(Color.YELLOW);
		         }
		      });
		
		Input6 = new JTextArea();
		Input6.setBounds(90, 780, 50, 90);
		Input6.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input6.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input6.setBackground(Color.YELLOW);
		         }
		      });
		
		
		Input7 = new JTextArea();
		Input7.setBounds(150, 500, 50, 90);
		Input7.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input7.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input7.setBackground(Color.YELLOW);
		         }
		      });
		
		Input8 = new JTextArea();
		Input8.setBounds(150, 640, 50 ,90);
		Input8.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input8.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input8.setBackground(Color.YELLOW);
		         }
		      });
	*/
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);
		
		
		btn1 = new JButton("�떒�뼱 �떆�뿕");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);
		
		
		
		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);
		
		btn3 = new JButton("�뮘濡�");
		btn3.setLayout(null);
		btn3.setBounds(850, 750, 100, 60);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new VocabToeic1Send ();
			f.setVisible(false);
			}
			
		});


		btn0 = new JButton("愿�由ъ옄 �럹�씠吏�濡� �룎�븘媛�湲�");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);
		
		
		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminOptionPage AP = new AdminOptionPage();
				AP.startFrame();
				f.setVisible(false);

			}
			
		});
		
		startframe();

		

//		Submit.setBackground(Color.gray);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Output1.getSelectedText() + Output2.getSelectedText() + Output3.getSelectedText()
				+Output4.getSelectedText() + Output5.getSelectedText() + Output6.getSelectedText() + Output7.getSelectedText()
				+ Output8.getSelectedText());
				
				if (Output1.getText() != null && Output2.getText() != null && Output3.getText() != null
						&&Output4.getText()!= null && Output5.getText() != null && Output6.getText()!= null
						&&Output7.getText()!= null && Output8.getText() !=null && Output9.getText() !=null
						&& Output10.getText() !=null && Output11.getText() !=null&& Output12.getText() !=null
						&& Output13.getText() !=null && Output14.getText() !=null && Output15.getText() !=null
						&& Output16.getText() !=null
						)  {
					String Output1a = Output1.getText();
					String Output2b = Output2.getText();
					String Output3c= Output3.getText();
					String Output4d = Output4.getText();
					String Output5e = Output5.getText();
					String Output6f= Output6.getText();
					String Output7g = Output7.getText();
					String Output8h = Output8.getText();
					String Output9h = Output9.getText();
					String Output10h = Output10.getText();
					String Output11h = Output11.getText();
					String Output12h = Output12.getText();
					String Output13h = Output13.getText();
					String Output14h = Output14.getText();
					String Output15h = Output15.getText();
					String Output16h = Output16.getText();

					dao.list(Output1a, Output2b, Output3c
							,Output4d,Output5e,Output6f,Output7g,
							Output8h, Output9h ,Output10h ,Output11h
,							Output12h,Output13h,Output14h,Output15h,Output16h);
				}
			}

		});

	

	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new AdminReading1();
			f.setVisible(false);

		}
	});

	
	
	btn2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HomeScreen hs = new HomeScreen();
			f.setVisible(false);
			hs.startFrame();
			
		}

	});

}
	/*
	 * @Override public void actionPerformed(ActionEvent e) { HomeScreen hs = new
	 * HomeScreen(); signup.setVisible(false);
	 * 
	 * hs.startFrame(); }
	 * 
	 * });
	 * 
	 * }
	 */
	public void startframe() {
		f.setSize(1000, 1200);
		p.add(title);

	//	p.add(PContent1);
	//	p.add(PContent2);
		//p.add(PContent3);
		p.add(Submit);

		p.add(Input1);
		p.add(Input2);
		p.add(Input3);
		p.add(Input4);
		p.add(Input5);
		p.add(Input6);
		p.add(Input7);
		p.add(Input8);

		
		p.add(Output1);
		p.add(Output2);
		p.add(Output3);
		p.add(Output4);
		p.add(Output5);
		p.add(Output6);
		p.add(Output7);
		p.add(Output8);
		p.add(Output9);
		p.add(Output10);
		p.add(Output11);
		p.add(Output12);
		p.add(Output13);
		p.add(Output14);
		p.add(Output15);
		p.add(Output16);
		p.add(btn0);

		
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);

		// f.add(title, "North");

		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		// p.add(Practice);

		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
	new VocabToeic3Send();
	}

	
	public void method() {
		//String list = "";
		String driver1 = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##green";
		String pwd = "green1234";

		try {
			Class.forName(driver1);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT Output1, Output2, Output3"
					+ "Output4,Output5,Output6,Output7,Output8 , Output9 , Output10 , Output11 , Output12 ,Output13 , Output14 , Output15 , Output16"
					+ " FROM VocabOut3";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("Output1") + "\t");
				System.out.print(rs2.getString("Output2") + "\t");
				System.out.print(rs2.getString("Output3"));

				Output1.setText(rs2.getString("Output1"));
				Output2.setText(rs2.getString("Output2"));
				Output3.setText(rs2.getString("Output3"));
				Output4.setText(rs2.getString("Output4"));
				Output5.setText(rs2.getString("Output5"));
				Output6.setText(rs2.getString("Output6"));
				Output7.setText(rs2.getString("Output7"));
				Output8.setText(rs2.getString("Output8"));
				Output9.setText(rs2.getString("Output9"));
				Output10.setText(rs2.getString("Output10"));
				Output11.setText(rs2.getString("Output11"));
				Output12.setText(rs2.getString("Output12"));
				Output13.setText(rs2.getString("Output13"));
				Output14.setText(rs2.getString("Output14"));
				Output15.setText(rs2.getString("Output15"));
				Output16.setText(rs2.getString("Output16"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
