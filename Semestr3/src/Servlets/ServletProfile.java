package Servlets;

import org.omg.PortableInterceptor.ServerRequestInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.11.15.
 */
public class ServletProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List profile = new ArrayList();
        String id=null;
        boolean find=false;
        HttpSession session = request.getSession();
        String avatar=null;
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
                ResultSet r = s.executeQuery("SELECT * FROM USERS");
                while (r.next()) {
                    if (session.getAttribute("user").equals(r.getString("name"))) {
                        System.out.println("ok");
                        avatar=(r.getString("path_user"));
                        System.out.println("ok");
                         id= r.getString("id_user");
                        System.out.println("ok");
                        find = true;

                    }
                }
                if(find==true){
                    System.out.println("ok");
                    r=s.executeQuery("SELECT *FROM CHOOSE WHERE id_user="+id);

                       while (r.next()) {
                           if(r.getString("path_picture")!=null) {
                        profile.add(r.getString("path_picture"));
                         System.out.println("ok");
                   }
                }
                }
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("avatar",avatar);
        request.setAttribute("profile", profile);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");

        if (dispatcher != null) {

            dispatcher.forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List profile = new ArrayList();
        String id = null;
        boolean find = false;
        HttpSession session = request.getSession();
        String avatar = null;
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        } else {
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
                    ResultSet r = s.executeQuery("SELECT * FROM USERS");
                    while (r.next()) {
                        if (session.getAttribute("user").equals(r.getString("name"))) {
                            System.out.println("ok");
                            avatar = (r.getString("path_user"));
                            System.out.println("ok");
                            id = r.getString("id_user");
                            System.out.println("ok");
                            find = true;

                        }
                    }
                    if (find == true) {
                        System.out.println("ok");
                        r = s.executeQuery("SELECT *FROM CHOOSE WHERE id_user=" + id);

                        while (r.next()) {
                            if (r.getString("path_picture") != null) {
                                profile.add(r.getString("path_picture"));
                                System.out.println("ok");
                            }
                        }
                    }
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.setAttribute("avatar", avatar);
            request.setAttribute("profile", profile);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");

            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }
        }
    }
}
