package ru;

/**
 * Created by User on 01.04.16.
 */
public class Student {
    String name;
    int id;

    public Student(){}

    public Student(String name, int id){
        this.name = name;
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
