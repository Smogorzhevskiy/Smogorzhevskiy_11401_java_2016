/**
 * Created by User on 09.03.16.
 */
public class Developer {

    private String name;

    public  String getName(){
        return  name;
    }

    public Developer(String name){
        this.name = name;

    }

    public void work(){
        System.out.println("I am working");
    }

    public void learnLanguage (String language){

        System.out.println("I  am learning language" + language);

    }
}