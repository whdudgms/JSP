package D0715_mvc.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {

    public static Connection getConnection(){
        Connection conn = null;
        String driver ="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521";
        String username ="c##madang";
        String password="madang";


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            System.out.println(conn);
        }
        return conn;
    }



    public static void close(ResultSet rs, Statement stmt, Connection conn){

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void close(  Statement stmt, Connection conn){
        try {

            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
