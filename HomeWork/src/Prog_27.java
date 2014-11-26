import java.io.*;
import java.util.*;
public class Prog_27 {

    public static void main(String[] args) {
        Polinom a = new Polinom(3);
        a.set(3, 5);
        a.set(2, 1);
        a.set(1, 3);
        a.set(0, 2);
        Polinom b = new Polinom(4);
        b.set(4, 1);
        b.set(3, 9);
        b.set(2, 2);
        b.set(1, 3);
        b.set(0, 6);
        int res = a.multi(a, b, 2);
        System.out.println(res);
    }
}
class Polinom {
    private int[] coeffs;

    public Polinom(int n) {
        coeffs = new int[n + 1];
    }

    void set(int i, int x) {
        coeffs[i] = x;
    }

    int get(int i) {
        if (i > coeffs.length)
            return 0;
        else return coeffs[i];
    }

    public int multi(Polinom a, Polinom b, int x) {
        int pa = 0;
        for (int i = a.coeffs.length - 1; i >= 0; i--) {
            pa *= x;
            pa += a.get(i);
        }
        int pb = 0;
        for (int i = b.coeffs.length - 1; i >= 0; i--) {
            pb *= x;
            pb += b.get(i);
        }
        return pa * pb;
    }

}

