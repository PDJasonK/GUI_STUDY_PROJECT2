package AAdminListening;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Listening01DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<Listening01vo> list(String listen1, String listen2) {
		ArrayList<Listening01vo> list = new ArrayList<Listening01vo>();
		try {

			System.out.println(listen1 + " ");
			connDB();
			String query;
			String cta1 = listen1;
			String cta2 = listen2;

//				query = "select * from instruction1  where contentsA = '" + contentsA + "'"+
//				" and contentsB = '" + contentsB.toLowerCase() + "'"+
//				" and contentsC = '" + contents3.toLowerCase() + "'";
			query = "insert into listening1 (listen1 ,listen2) VALUES('" + cta1 + "', '" + cta2 + "')";

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

			String sql2 = "SELECT listen1 , listen2 FROM listening1";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}