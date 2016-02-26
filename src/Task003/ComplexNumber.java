package Task003;

public class ComplexNumber {
    private double i = 0,j = 0, ImPart,RePart;

    public ComplexNumber() {
       this(0,0);
        getI();
        getJ();
    }


    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

    public ComplexNumber(double i, double j) {
        this.i = i;
        this.j = j;

    }


    public ComplexNumber add(ComplexNumber c) {
        ComplexNumber cn = new ComplexNumber (ImPart = this.i + c.i,
                RePart = this.j + c.j);
        return cn;
    }
    public void add2(ComplexNumber cn) {
        ImPart = this.i + cn.i;
        RePart = this.j + cn.j;
    }
    public ComplexNumber sub(ComplexNumber c){
        ComplexNumber cn = new ComplexNumber(ImPart = this.i - c.i, RePart = this.j - c.j);
        return cn;
    }
    public void sub2(ComplexNumber cn) {
        ImPart = this.i - cn.i;
        RePart = this.j - cn.j;
    }
    public ComplexNumber multNumber(double c) {
        ComplexNumber cn = new ComplexNumber(ImPart = this.i * c, RePart = this.j * c);
        return cn;
    }
    public void multNumber2(double c){
        ImPart = this.i * c;
        RePart = this.j * c;
    }
    public ComplexNumber mult(ComplexNumber c) {

        ComplexNumber cn = new ComplexNumber(ImPart = this.i * c.j + this.j * j,RePart = this.i * c.j - this.j * c.i);
        return cn;
    }
    public void mult2(ComplexNumber cn){
        ImPart = this.i * cn.j + this.j * j;
        RePart = this.i * cn.j - this.j * cn.i;
    }
    public ComplexNumber div(ComplexNumber c){
        ComplexNumber cn = new ComplexNumber(ImPart = (-this.i * c.i - this.j * c.j)/(i*i * j*j),RePart = (this.i * c.j + this.j * c.i)/(i*i + j*j));
        return cn;
    }
    public void div2(ComplexNumber cn){

        ImPart = (-this.i * cn.i - this.j * cn.j)/(i*i * j*j);

        RePart = (this.i * cn.j + this.j * cn.i)/(i*i + j*j);
    }
    public double length(){
        return Math.sqrt(this.i * this.i + this.j * this.j);
    }
    public String toString(){
        if (j >= 0)
            return this.i + "+" +  this.j + "i";
        else
            return this.i + "-" + -this.j + "i";
    }
    public double arg() {
        return Math.atan2(this.i , this.j);
    }

    public ComplexNumber pow(double c){
        return new ComplexNumber(Math.pow(length(), c) * Math.cos(c * arg()), Math.pow(length(), c) * Math.sin(c * arg()));
    }
    public boolean equals(ComplexNumber cn) {
        if (this.i == cn.i && this.j == cn.j) {
            return true;
        }
        else {
            return false;
        }
    }

}