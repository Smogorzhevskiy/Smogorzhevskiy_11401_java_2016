package Servlets;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class Registration extends Dispatcher {
    public String getServletInfo() {
        return "Registration servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        if (request.getParameter("login") != null) {
            this.forward("/CheckUser", request, response);

        } else if (request.getParameter("registration") != null) {
            this.forward("/registration.html", request, response);
        }
        if (request.getParameter("artists") != null) {
            this.forward("/DataServlet", request, response);
        }
        if (request.getParameter("logout") != null) {
            this.forward("/Logout", request, response);
        }
        if (request.getParameter("profile") != null) {
            this.forward("/ServletProfile", request, response);
        }

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("artists") != null) {
            this.forward("/DataServlet", request, response);
        }
            if (request.getParameter("login") != null) {
                this.forward("/CheckUser", request, response);
            }
    }

    }

