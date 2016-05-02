package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 30.03.16.
 */
public class MySQLFactoryDao implements DaoFactory {

    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public MySQLFactoryDao() throws ClassNotFoundException {
        Class.forName(driver);
    }

    @Override
    public StudentDao getStudentDao(Connection connection) {
        return new MySQLStudentDao(connection);
    }

}
