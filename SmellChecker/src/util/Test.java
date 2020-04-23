package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mariadb.jdbc.internal.util.constant.Version;


public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("konnai");


		Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            System.out.println("Connector/J " + Version.version + "\n");

            System.out.print("Connecting to DB...");
            conn = DriverManager.getConnection(
//                "jdbc:mariadb://118.27.0.42/main", "smellcheck", "kosugi1111");
                    "jdbc:mariadb://localhost/main", "smellcheck", "kosugi1111");

            System.out.println(" done.");

            stmt = conn.createStatement();
            String sql = "SELECT user,host FROM mysql.user";
            ResultSet hrs = stmt.executeQuery(sql);

            while (hrs.next()) {
                String user = hrs.getString(1);
                String host = hrs.getString(2);
                System.out.println("User: " + user + "@'" + host + "'");
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {} // do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("\nGoodbye!");

	}

}
