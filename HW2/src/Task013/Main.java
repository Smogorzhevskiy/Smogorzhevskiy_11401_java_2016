package Task013;

/**
 * Created by User on 21.03.16.
 */
public class Main {

    public static void main(String[] args) {
        String name = "Logan";
        String mail = "x-men@gmail.com";
        User user = new User(name, mail);
        System.out.println("name: " + user.name + " mail" + user.mail);
    }
}
