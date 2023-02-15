package AdminVocabQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import AdminVocab.VocabToeic1OutVo;




public class VocabToeic3SendDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<VocabToeic1OutVo> list(String Output1, String Output2, String Output3, String Output4,
			String Output5, String Output6, String Output7, String Output8, String Output9, String Output10,
			String Output11, String Output12, String Output13, String Output14, String Output15, String Output16) {
		ArrayList<VocabToeic1OutVo> list = new ArrayList<VocabToeic1OutVo>();
		try {

			System.out.println(Output1 + " " + Output2 + " " + Output3 + " " + Output4 + " " + Output5 + " " + Output6
					+ " " + Output7 + " " + Output8 + "" + Output9 + " " + Output10 + " " + Output11 + " " + Output12
					+ " " + Output13 + " " + Output14 + " " + Output15 + " " + Output16);
			connDB();
			String query;
			String cta1 = Output1;
			String cta2 = Output2;
			String cta3 = Output3;
			String cta4 = Output4;
			String cta5 = Output5;
			String cta6 = Output6;
			String cta7 = Output7;
			String cta8 = Output8;
			String cta9 = Output9;
			String cta10 = Output10;
			String cta11 = Output11;
			String cta12 = Output12;
			String cta13 = Output13;
			String cta14 = Output14;
			String cta15 = Output15;
			String cta16 = Output16;

//				query = "select * from instruction1  where contentsA = '" + contentsA + "'"+
//				" and contentsB = '" + contentsB.toLowerCase() + "'"+
//				" and contentsC = '" + contents3.toLowerCase() + "'";
			query = "insert into VocabQuiz3(Output1, Output2,Output3,Output4,Output5,Output6,Output7,Output8 , Output9 , Output10 , Output11 , Output12 , Output13 , Output14 , Output15 , Output16) "
					+ "VALUES('" + cta1 + "', '" + cta2 + "', '" + cta3 + "', '" + cta4 + "', '" + cta5 + "', '" + cta6
					+ "', '" + cta7 + "', '" + cta8 + "', '" + cta9 + "', '" + cta10 + "', '" + cta11 + "', '" + cta12 + "', '" + cta13 + "', '" + cta14 + "', '" + cta15 + "', '" + cta16 + "')";

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);

//			if (rs.getRow() == 0) {
//				System.out.println("0 row selected....");
//				
//				System.out.println(query);
//
//				System.out.println("Join complete");
//
//			} else {
//				System.out.println(rs.getRow() + "rows selected...");
//				System.out.println("can not join");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection success.");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");

			String sql2 = "SELECT Output1, Output2, Output3 ,Output4,Output5,Output6,Output7,Output8 FROM VocabQuiz3";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}