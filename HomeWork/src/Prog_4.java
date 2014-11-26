import java.io.*;
import java.util.*;
public class Prog_4 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int k=0;
        while (x>1) {
            if (x % 2 == 0)
                x = x / 2;
            else
                x = x * 3 - 1;
            System.out.print(x + " ");
            k++;
        }
        System.out.println(k);
    }
}
