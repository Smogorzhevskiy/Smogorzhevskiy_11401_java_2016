package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

public class DataServlet extends HttpServlet {

    List dataList = new ArrayList();

    public void Find() {

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
                ResultSet r = s.executeQuery("SELECT * FROM ARTISTS");

                while (r.next()) {


                    dataList.add(r.getString("name"));

                    dataList.add(r.getInt("id_artist"));


                    dataList.add(r.getString("path_artist"));

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p;
        HttpSession session = request.getSession();
        String artists = request.getParameter("artists");

            Find();
            request.setAttribute("data", dataList);
            if (session.getAttribute("user").equals("Allan")) {
                p="Artist(Admin).jsp";
                System.out.println("good");
            }else {p="Artist.jsp";
                System.out.println("go");}
                RequestDispatcher dispatcher = request.getRequestDispatcher(p);


                if (dispatcher != null) {

                    dispatcher.forward(request, response);

                }

            dataList.clear();





    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p;
        HttpSession session = request.getSession();
        String artists = request.getParameter("artists");

            Find();
            request.setAttribute("data", dataList);
            if (session.getAttribute("user").equals("Allan")) {
                p="Artist(Admin).jsp";
                System.out.println("good");
            }else {p="Artist.jsp";
                System.out.println("go");}
            RequestDispatcher dispatcher = request.getRequestDispatcher(p);


            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }

            dataList.clear();





    }




}
