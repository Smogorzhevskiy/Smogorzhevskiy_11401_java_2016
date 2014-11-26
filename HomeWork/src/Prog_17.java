import java.util.*;
import java.util.Scanner;
public class Prog_17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Введите кол-во чисел: ");
        int n=sc.nextInt();
        int k=0,min=999999999;
        int a[]=new int[n];
        System.out.println("Введите числа:");
        for (int i=0; i<n; i++)
            a[i]=sc.nextInt();
        for (int i=0; i<n; i++) {
            if (a[i]<min) {
                for (int j=i+1; j<n; j++) {
                    if (a[j]<0)
                        k++;
                }
                if (k!=0 && k%2==0)
                    min=a[i];
            }
            k=0;
        }
        System.out.print("Минимальное число, за которым идет четное кол-во отрицательных чисел: "+min);
    }
}