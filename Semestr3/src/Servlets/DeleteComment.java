package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 10.11.15.
 */
public class DeleteComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
siteRepository sr = new siteRepository();
        sr.deleteComment(request.getParameter("author"),"COMMENTS_USERS");
        request.setAttribute("id", request.getParameter("id"));
        System.out.println("ssssss"+request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DataServlet");

        if (dispatcher != null) {

            dispatcher.forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
