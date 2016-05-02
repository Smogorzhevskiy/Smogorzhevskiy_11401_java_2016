package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.StudentDao;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.Student;

import java.sql.SQLException;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentDao studentsDao;


    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public String getAllStudents(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("students", studentsDao.getAllStudents());
        return "student";
    }

    @RequestMapping(value = "/getStudentId/{id}",method = RequestMethod.GET)
    public @ResponseBody Student getStudentId(@PathVariable(value = "id") int id) throws SQLException, ClassNotFoundException {
        return studentsDao.read(id);
    }
}