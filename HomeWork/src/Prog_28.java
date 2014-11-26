import java.io.*;
import java.util.*;
public class Prog_28 {
    public static void main(String[] args) {
        Polinom1 a = new Polinom1(2);
        a.set(10, 2);
        a.set(7, 3); 
        a.set(4, 2);

        for (int i = 0; i < a.coeffs.length; i++)
            System.out.print(a.get(i) + "x^" + a.getd(i) + "+");


    }
}
class Polinom1{
    int[] coeffs;
    int[] d;
    private int l = 0;

    public Polinom1(int n) {
        coeffs = new int[n + 1];
        d= new int[n + 1];
    }

    void set(int i, int x) {
        if (l <= coeffs.length) {
            coeffs[l] = x;
            d[l] = i;
            l++;
        }

    }

    int get(int i) {
        if (i > coeffs.length)
            return 0;
        else return coeffs[i];
    }

    int getd(int i) {
        if (i > coeffs.length)
            return 0;
        else return d[i];
    }

}


