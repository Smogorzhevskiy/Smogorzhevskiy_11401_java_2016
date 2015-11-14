package Servlets;

import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Created by User on 07.11.15.
 */
public class siteRepository {


    protected boolean findUser(String user_name, String user_pass) {
        boolean find = false;

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
                    if (user_name.equals(r.getString("name")))
                        if (user_pass.equals(r.getString("user_password"))) {
                            System.out.println(r.getString("name"));
                            find = true;
                            break;}
                }
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return find;
    }


    protected void addComment(String id,String author, String text) {


        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");


            String queryInsert = "INSERT INTO COMMENTS_USERS (id_picture,author,comment_user)"
                    + "values (?, ?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, author);
            preparedStmt.setString(3, text);


            preparedStmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    protected boolean checkForRegistration(String user_name) {
        boolean check = true;

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
                    if (user_name.equals(r.getString("name"))){
                        System.out.println(r.getString("name"));
                        check = false;
                        break;}
                }
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return check;
    }


    protected void addPhoto(String name_u,String name_p){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");

                    String queryInsert = "update users set path_user='images/Avatars/"+name_p+"' where name='"+name_u+"'";

                    PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);



                    preparedStmt.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    protected void delete(String name,String table_p){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");


            String queryInsert = "delete from "+table_p+ " where name='"+name+"'";
            System.out.println("del");
            System.out.println(name);
deleteAllComment(name, table_p);
            if(table_p.equals("artists")){
                deleteArtistPicture(name);
            }
            PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);



            preparedStmt.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



    protected void addArtist(String name,String avatar) {//,String avatar


        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");


            String queryInsert = "INSERT INTO ARTISTS (name, path_artist)" //,path_artist
                    + "values (?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, "images/Avatars/"+avatar);


            preparedStmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    protected void deleteComment(String id_comment,String table_p){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");


            String queryInsert = "delete from "+table_p+ " where id_comment='"+id_comment+"'";
            System.out.println("del");
            System.out.println(id_comment);

            PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);



            preparedStmt.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    protected void addWorks(String name, String id_author,String avatar) {

System.out.println(id_author);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");


            String queryInsert = "INSERT INTO PICTURE (name, id_artist, path_picture)" //
                    + "values (?,?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(queryInsert);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, id_author);
            preparedStmt.setString(3, "images/Avatars/"+avatar);


            preparedStmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void deleteAllComment(String name_p,String table_p){
        String id_p=null;
        String path;
        String tab;
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
                if(table_p.equals("picture")){
                    path="SELECT * FROM PICTURE";
                    tab="id_picture";
                }else{
                    path="SELECT * FROM artists";
                    tab="id_artist";

                }
                ResultSet r = s.executeQuery(path);
                while (r.next()) {
                    if (name_p.equals(r.getString("name"))) {
                        id_p = r.getString(tab);
                        break;
                    }
                }


                s.close();
                String queryInsert = "delete from comments_users where "+tab+"='"+id_p+"'";
                System.out.println("delAllcom");

                PreparedStatement preparedStmt = con.prepareStatement(queryInsert);
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void deleteArtistPicture(String name_p) {
        String id_p = null;
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
                ResultSet r = s.executeQuery("SELECT * FROM artists");
                while (r.next()) {
                    if (name_p.equals(r.getString("name"))) {
                        id_p = r.getString("id_artist");
                        break;
                    }
                }
                s.close();
                String queryInsert = "delete from picture where id_artist='" + id_p + "'";
                System.out.println("delAllpict");

                PreparedStatement preparedStmt = con.prepareStatement(queryInsert);
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    }