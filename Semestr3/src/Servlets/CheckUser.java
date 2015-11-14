package Servlets;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckUser extends Dispatcher {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        siteRepository sr = new siteRepository();
        HttpSession session = request.getSession();
        String user1 = (String) session.getAttribute("user");
        System.out.println("SESSION");

            String name = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(sr.findUser(name, password));
        if (sr.findUser(name, password)) {
            session.setAttribute("user", name);
            if (user1 != null) {
                if (request.getParameterValues("remember") != null) {
                    Cookie cookie = new Cookie(name, name);
                    cookie.setMaxAge(600);
                    response.addCookie(cookie);
                }
                response.sendRedirect("/index.jsp");
            }else {response.sendRedirect("/login.jsp");}
        }else {

            response.sendRedirect("/errorRegistration.html");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user1 = (String) session.getAttribute("user");
        if (user1 == null) {response.sendRedirect("/login.jsp");}
    }


    }