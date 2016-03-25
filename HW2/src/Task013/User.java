package Task013;


public class User {
    String name;
    String mail;

    public User() {
    }

    public User(String name, String mail) {
        setName(name);
        setMail(mail);
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
        System.out.println("name: " + name + " mail: " + mail);

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
