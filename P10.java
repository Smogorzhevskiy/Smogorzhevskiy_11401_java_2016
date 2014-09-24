import java.io.*;
import java.util.*;
public class P10 {
    public static void main (String[]args){
        Scanner sc=new Scanner(System.in);
       int x=sc.nextInt();
       double p=2*x;
        double g=2*x;
        while (g>2){
            p=1+1/(1+1/p);
            p=(g-2)+1/p;
            g-=2;
            }
        p=2+1/(1+1/p);
        System.out.print(p);
    }
}
