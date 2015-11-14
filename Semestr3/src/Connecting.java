
import  java.sql.Statement;
import  java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;
public class Connecting {


    public static void main(String[] args) {


        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            String url = "jdbc:mysql://localhost:3306/newdb";
            System.out.println("Driver loading success!");
            String name = "root";
            String password = "";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                System.out.println("connect");
                con.close();
                System.out.print("dis");
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}