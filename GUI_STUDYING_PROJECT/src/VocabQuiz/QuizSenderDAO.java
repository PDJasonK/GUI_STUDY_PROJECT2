package VocabQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuizSenderDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<QuizSenderVo> list(String Reading1, String Reading2, String Reading3) {
		ArrayList<QuizSenderVo> list = new ArrayList<QuizSenderVo>();
		try {
			connDB();
			String query = "select * from ReadingQuiz1 ";

			if (Reading1 != null && Reading2 != null && Reading3 != null) {
				query += " where Reading1 = '" + Reading1.toLowerCase() + "'";
				query += " and Reading2 = '" + Reading2.toLowerCase() + "'";
				query += " and Reading3 = '" + Reading3.toLowerCase() + "'";

			}

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected....");
				rs.previous();
				query = "insert into ReadingQuiz1 (Reading1, Reading2 ,Reading3) ";
				query += "VALUES('" + Reading1 + "', '" + Reading2 + "', '" + Reading3 + "', '" + "')";
				System.out.println(query);

				stmt.executeQuery(query);
				System.out.println("Join complete");

			} else {
				System.out.println(rs.getRow() + "rows selected...");
				System.out.println("can not join");
			}

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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}