import java.io.*;
import java.util.*;
public class Prog_16 {
    public static void main (String [] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int [] a=new int [x];
        int max1, max2=0;
        for (int i=0; i<x; i++){
            a[i]=sc.nextInt();
            if (a[i]<0){
                max1=a[i-1];

            if (max1>max2)
                max2=max1;
            }
        }
        System.out.println(max2);
    }

}
