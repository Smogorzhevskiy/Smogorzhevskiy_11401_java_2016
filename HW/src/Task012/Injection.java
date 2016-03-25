package Task012;

/**
 * Created by User on 23.03.16.
 */
public class Injection {

    String in;

    public void execute(String in) {
        this.in = in;
        System.out.println("The method is executed: in = [" + in + "]");
    }
}
