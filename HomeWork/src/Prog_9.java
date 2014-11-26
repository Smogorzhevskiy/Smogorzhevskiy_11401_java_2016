import java.io.*;
import java.util.*;
public class Prog_9 {
    public static void main(String[] args){
        double x=Math.sqrt(2);
        double s=x/2;
        while (x/2<1){
            x=Math.sqrt(2+x);
            s*=(x/2);
        }
        System.out.print(s);

    }
}
