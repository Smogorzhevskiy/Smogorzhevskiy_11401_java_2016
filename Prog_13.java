import java.io.*;
import java.util.*;
public class Prog_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int s = 0, a, b ;
        for (int i=y; i>0; i--)
        {
            b = 1;
            for (int j=i; j>0; j--)
                b *= x;
                a = sc.nextInt();
                s += a * b;

        }
        System.out.print(s);
    }
}

