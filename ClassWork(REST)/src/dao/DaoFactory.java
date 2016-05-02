package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by User on 30.03.16.
 */
public interface DaoFactory {

    public Connection getConnection() throws SQLException;
    public StudentDao getStudentDao(Connection connection);



}
