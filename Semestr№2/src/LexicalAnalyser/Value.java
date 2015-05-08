package LexicalAnalyser;


public class Value {

    private String name;
    private int value;
    private String type;

    public Value() {
        this.name = "";
        this.value = 0;
        this.type = "";
    }

    public String getName(){
        return name;
    }
    public int getValue() {
        return value;
    }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setValue (int value) { this.value = value; }
    public void setType (String type) { this.type = type; }

    public String toString() {
        return name + " = " + Integer.toString(value);
    }
}