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
 * Created by User on 31.10.15.
 */
public class AuthorServlet extends HttpServlet {
    List pictureList = new ArrayList();

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

                    if(id.equals(r.getString("id_artist"))) {
                        pictureList.add(r.getString("path_picture"));
                        pictureList.add(r.getInt("id_picture"));
                        System.out.println(r.getString("id_picture"));
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

        if (request.getParameter("delete") != null) {
            siteRepository sr = new siteRepository();
            sr.delete(request.getParameter("name"), "artists");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DataServlet");

            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }

        } else {
            if (request.getParameter("add") != null) {
                System.out.println(request.getParameter("add"));
                request.setAttribute("id_author",request.getParameter("add_picture"));
                System.out.println(request.getParameter("add_picture"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("AddWorks.jsp");

                if (dispatcher != null) {

                    dispatcher.forward(request, response);

                }
            }else{
                if(request.getParameter("id")==null){
                    Find((String)request.getAttribute("id"));
                } else{
            Find(request.getParameter("id"));}
            request.setAttribute("list", pictureList);
            if (session.getAttribute("user").equals("Allan")) {
                p = "Artworks(Admin).jsp";
                System.out.println("good");
            } else {
                p = "Artworks.jsp";
                System.out.println("go");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(p);
            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }
            pictureList.clear();
        }
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        }
    }
}
