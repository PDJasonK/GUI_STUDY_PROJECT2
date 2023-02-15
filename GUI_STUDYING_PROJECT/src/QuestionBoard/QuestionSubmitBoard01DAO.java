package QuestionBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import VocabQuiz.VocabiQuizVo1;

public class QuestionSubmitBoard01DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<QuestionSubmitBoard01Vo> list(String reading1, String reading2, String reading3,
			String reading4) {
		ArrayList<QuestionSubmitBoard01Vo> list = new ArrayList<QuestionSubmitBoard01Vo>();
		try {

			System.out.println(reading1 + " " + reading2 + " " + reading3);
			connDB();
			String query;
			String ct1 = reading1;
			String ct2 = reading2;
			String ct3 = reading3;
			String ct4 = reading4;

			query = "insert into Question1 (reading1, reading2, reading3, reading4)" + " VALUES('" + ct1 + "', '" + ct2
					+ "', '" + ct3 + "', '" + ct4 + "')";

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);

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

			String sql2 = "SELECT reading1, reading2, reading3, reading4 FROM Question1";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}