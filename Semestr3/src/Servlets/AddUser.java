package Servlets;

        import java.io.*;
        import java.sql.*;
        import javax.servlet.*;
        import javax.servlet.http.*;
public class AddUser extends Dispatcher {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        siteRepository sr=new siteRepository();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        if(req.getAttribute("cancel")==null){
            resp.sendRedirect("/login.jsp");
        }
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");

            String loginEqual = req.getParameter("user");
            String passwordEqual = req.getParameter("password");
            if(sr.checkForRegistration(loginEqual)==false){
                System.out.println("false");
                resp.sendRedirect("/errorRegistration.html");}else {

                String queryInsert = "INSERT INTO users (name, user_password)"
                        + " values (?, ?)";

                PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);
                preparedStmt.setString(1, loginEqual);
                preparedStmt.setString(2, passwordEqual);


                preparedStmt.execute();

                resp.sendRedirect("/login.jsp");
            }

        }
        catch (SQLException e)
        {
            pw.print("Нет подключения к базе данных1");
        }
        catch (Exception ex){
            pw.print("Нет подключения к базе данных2");
        }

    }

}
