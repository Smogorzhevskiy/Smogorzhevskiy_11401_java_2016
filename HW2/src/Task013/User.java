package Task013;

/**
 * Created by User on 21.03.16.
 */
public class User {
    String name;
    String mail;

    public User(String name, String mail) {
        setName(name);
        setMail(mail);
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
