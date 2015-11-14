package Servlets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


public class FindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        String type = request.getParameter("types");
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT name from "+ type +" WHERE name like '%"+q+"%'");

           // ps.setString(1, "'%" + q + "%'");
            //ResultSet rs = ps.executeQuery();
            JSONArray ja = new JSONArray();
            while (rs.next()) {
                ja.put(rs.getString("name"));
            System.out.println(rs.getString("name"));
            }
            JSONObject jo = new JSONObject();
            jo.put("results", ja);
            response.setContentType("text/json");
            response.getWriter().print(jo.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
