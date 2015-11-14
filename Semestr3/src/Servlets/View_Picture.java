package Servlets;

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
 * Created by User on 06.11.15.
 */
public class View_Picture extends HttpServlet {

    List comments = new ArrayList();
    String picture;
    String artist;
    String path;


    public void Find(String id){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            String url = "jdbc:mysql://localhost:3306/newdb";
            System.out.println("Driver loading success!");
            String name = "root";
            String password = "";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                System.out.println("connectddd");
                Statement s = con.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM PICTURE");

                while (r.next()) {

                    if(id.equals(r.getString("id_picture"))) {
                        path=(r.getString("path_picture"));
                        artist=(r.getString("id_artist"));
                        picture=(r.getString("name"));
                        System.out.println(path+artist+picture);
                    }
                }

                r.close();

                s.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void art(String id){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            String url = "jdbc:mysql://localhost:3306/newdb";
            System.out.println("Driver loading success!");
            String name = "root";
            String password = "";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                System.out.println("connectddd");
                Statement s = con.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM ARTISTS");

                while (r.next()) {

                    if(id.equals(r.getString("id_artist"))) {

                        artist=r.getString("name");
                        System.out.println(artist);
                        break;

                    }
                }

                r.close();

                s.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void comment(String id){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            String url = "jdbc:mysql://localhost:3306/newdb";
            System.out.println("Driver loading success!");
            String name = "root";
            String password = "";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                System.out.println("connectddd");
                Statement s = con.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM COMMENTS_USERS");

                while (r.next()) {

                    if(id.equals(r.getString("id_picture"))) {
                        user_avatar(r.getString("author"));
                        comments.add(r.getString("author"));
                        comments.add(r.getString("comment_user"));
                        comments.add(r.getString("id_comment"));


                    }
                }

                r.close();

                s.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void user_avatar(String id){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            String url = "jdbc:mysql://localhost:3306/newdb";
            System.out.println("Driver loading success!");
            String name = "root";
            String password = "";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                System.out.println("connectddd");
                Statement s = con.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM USERS");

                while (r.next()) {

                    if(id.equals(r.getString("name"))) {

                        comments.add(r.getString("path_user"));
                        break;

                    }
                }

                r.close();

                s.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String p;

        if(request.getParameter("delete")!=null){
            System.out.println("delete !null");
            Find(request.getParameter("iddel"));
            siteRepository  sr= new siteRepository();
            sr.delete(picture,"PICTURE");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DataServlet");

            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }

        }else{
            if (request.getParameter("id") != null) {
                Find(request.getParameter("id"));
            } else {
                Find((String) request.getAttribute("id"));
            }
            art(artist);
            comment(request.getParameter("id"));
            request.setAttribute("comments", comments);
            request.setAttribute("picture", picture);
            request.setAttribute("path", path);
            request.setAttribute("artist", artist);
            request.setAttribute("id", request.getParameter("id"));
            System.out.println(path + artist + picture);
            System.out.println(comments);
            if (session.getAttribute("user").equals("Allan")) {
                p = "Picture(Admin).jsp";
                System.out.println("good");
            } else {
                p = "Picture.jsp";
                System.out.println("go");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(p);

            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }
            comments.clear();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.sendRedirect("Artworks.jsp");
    }
}
