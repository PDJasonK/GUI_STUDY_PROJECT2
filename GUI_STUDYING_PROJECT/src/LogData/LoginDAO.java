package LogData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet resulty = null;


	public int login(String userID, String userPassword) {
		String SQL = "SELECT pwd FROM profile WHERE id = ?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			resulty = pstmt.executeQuery();
			if (resulty.next()) {
				if (resulty.getString(1).contentEquals(userPassword)) {
					return 1; // 濡쒓렇�씤 �꽦怨듭떆 1 諛섑솚
				} else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return -2;
	}

	public int logincheck(String userID) {
		String SQL = "select teacher FROM profile where id = ?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			resulty = pstmt.executeQuery();
			if (resulty.next()) {
				System.out.println(resulty.getString(1));
				if (resulty.getString(1).contentEquals(" admin")) {
					return 1;
				} else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}

	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driver); // 1. �뱶�씪�씠踰� 濡쒕뵫
			con = DriverManager.getConnection(url, user, pwd); // 2. �뱶�씪�씠踰� �뿰寃�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}