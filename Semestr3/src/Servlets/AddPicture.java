package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.DefaultPersistenceDelegate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddPicture extends HttpServlet {

    protected boolean CheckChoose(String id, String path){
        boolean check=true;
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
                Statement s = con.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM CHOOSE");
                while (r.next()) {
                    if (id.equals(r.getString("id_user"))&& path.equals(r.getString("path_picture"))){

                        check = false;
                        break;}
                }
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return check;
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_user=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");

            String path = request.getParameter("id");
            HttpSession session = request.getSession();



            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM USERS");
            while (r.next()) {
                if ((session.getAttribute("user")).equals(r.getString("name"))) {
                    id_user=r.getString("id_user");
                    break;
                }
            }
if(CheckChoose(id_user,path)==true) {


    String queryInsert = "INSERT INTO choose (id_user,path_picture)"
            + " values (?, ?)";

    PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);
    preparedStmt.setString(1, id_user);
    preparedStmt.setString(2, path);


    preparedStmt.execute();
    PrintWriter out = response.getWriter();
    out.print("Add ok");

}else {PrintWriter out = response.getWriter();
    out.print("Already added");}


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

