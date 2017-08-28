package Com.Util;


import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/lillyexittest";
         
       //String url = "jdbc:mysql://mysql26969-lillyexittest.cloud.cms500.com/lillyexittest";
        String username = "root";
        String password = "root";
        //String password = "RRLnzp41939";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password);
            System.out.print("Connection suceesull");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}