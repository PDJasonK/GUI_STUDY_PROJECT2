package AdminReading1DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadingMain2DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<ReadingMain2Vo> list(String send1, String send2, String send3) {
		ArrayList<ReadingMain2Vo> list = new ArrayList<ReadingMain2Vo>();
		try {

			System.out.println(send1 + " " + send2 + " " + send3);
			connDB();
			String query;
			String cta1 = send1;
			String cta2 = send2;
			String cta3 = send3;

			query = "insert into ReadingMainSend (send1, send2,send3)" + " VALUES('" + cta1 + "', '" + cta2 + "', '"
					+ cta3 + "')";

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

			String sql2 = "SELECT send1, send2, send3 FROM ReadingMainSend";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}