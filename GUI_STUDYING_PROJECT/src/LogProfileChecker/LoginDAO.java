package LogProfileChecker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	String user = "c##green";
	String pwd = "green1234";

   private Connection con;
   private Statement stmt;
   private ResultSet resulty;

   public ArrayList<LoginVo> list(String id, String pwd) {
      ArrayList<LoginVo> list = new ArrayList<LoginVo>();
      try {
         connDB();
         String query = "select *from profile ";
         if (id != null && pwd != null) {
            query += "where id = '" + id.toLowerCase() + "'";
            query += "and pwd = '" + pwd.toLowerCase() + "'";

         }
         System.out.println("SQL : " + query);

         resulty = stmt.executeQuery(query);
         resulty.last();

         if (resulty.getRow() == 0) {
            System.out.println("0 row selected.....");
         } else {
            System.out.println(resulty.getRow() + "rows selected.....");
            resulty.previous();
            while (resulty.next()) {
               String pid = resulty.getString("id");
               String ppwd = resulty.getString("pwd");

               LoginVo data = new LoginVo(pid, ppwd);
               list.add(data);
            }
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