/**
 * Created by sentpim on 26.02.2016.
 */
public class Lesson {
    private String name;
    Lesson (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
