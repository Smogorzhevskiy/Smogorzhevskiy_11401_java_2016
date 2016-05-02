package dao;

import com.sun.tools.javac.util.List;
import ru.Student;

import java.sql.SQLException;

/**
 * Created by User on 30.03.16.
 */
public interface StudentDao {

    public Student create();

    public Student read(int id) throws SQLException;

    public void update(Student student);

    public void delete(Student student);

    public List<Student> getAllStudents() throws SQLException;
}
