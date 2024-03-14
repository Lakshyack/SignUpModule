package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDbase {
    public Connection ConnectDB(String DataBase) {
        try {
            String url1 = "jdbc:mysql://localhost:3306/";
            String url2 = DataBase;
            String url = url1 + url2;
            String user = "root";
            String password = "@Lakshya82#";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            if (con.isClosed()) {
                System.out.println("Connection is not Established");
            } else {
                System.out.println("Connection is  established");
                return con;
            }
        } catch (Exception e) {

        }
return null;
    }



}
