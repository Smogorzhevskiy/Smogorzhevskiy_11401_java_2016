import java.io.*;
import java.util.*;
public class P8 {
   public static void main(String[]args){
       Scanner sc=new Scanner(System.in);
       double x=sc.nextDouble();
       double n=x*x*x, p=(x*x*x*x*x)/2, eps=1e-6, s=n+p;
       int k=3;
       while((n>eps)||(p>eps)){
           if (k%2==1){
               n=n*((x*x*x*x)/k);
               s+=n;
           }
       else{
               p=p*((x*x*x*x)/k);
               s+=p;
           }
           k++;
       }
     System.out.print(s);

   }
}
