package dao;

import com.sun.tools.javac.util.List;
import ru.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by User on 30.03.16.
 */
public class MySQLStudentDao implements StudentDao {

    private Connection connection;

    public MySQLStudentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Student create() {
        return null;
    }

    @Override
    public Student read(int id) throws SQLException {
        String sql = "SELECT *FROM .... WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Student student = new Student();
        student.setId(rs.getInt("id"));
        Student.setName(rs.getString("name"));
        return student;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT * FROM";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List< Student> list = new ArrayList<Student>();


    }
}
