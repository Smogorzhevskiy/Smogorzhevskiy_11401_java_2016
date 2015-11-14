package Servlets;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.sql.*;

/**
 * Created by User on 06.11.15.
 */
public class Add_Comments extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        siteRepository sr=new siteRepository();
        HttpSession s= request.getSession();
        sr.addComment(request.getParameter("id"),(String)s.getAttribute("user"),request.getParameter("text"));
        request.setAttribute("id", request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View_Picture");

        if (dispatcher != null) {

            dispatcher.forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}