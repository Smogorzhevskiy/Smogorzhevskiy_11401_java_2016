package Task002;

import java.util.List;

/**
 * Created by User on 26.02.16.
 */
public class Student {

    private String name;
    private Institute institute;
    private List<Lesson> lessons;

    public Student(String name, Institute institute){
        this.name = name;
        this.institute = institute;
    }
}
