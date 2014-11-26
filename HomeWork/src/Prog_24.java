import java.io.*;
import java.util.*;
public class Prog_24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [] [] a = new double [n] [n];
        for (int i = 0; i<n; i++)
            for (int j = 0; j<n; j++)
                a[i][j]=sc.nextInt();
        for (int j = 0; j<n-1; j++)
        {
            a=swap(a,j);
            a=subtraction(a,j);
        }
        for (int i=0; i<n; i++){
            System.out.println();
            for (int j=0; j<n; j++)
                System.out.print(a[i][j]+" ");
        }
        System.out.println();
        System.out.println("Определитель равен ="+detA(a));
    }

    public static double [] [] swap (double [][] a, int j)
    {
        int n = a.length;
        double x;
        int y=0;
        int i = j;
        while (y==0)
        {
            if (a[j][j]!=0)
                y = 1;
            else
            if (a[i][j]!=0)
            {
                for (int l=0; l<n; l++)
                {
                    x = (-1)*a[j][l];
                    a[j][l]=a[i][l];
                    a[i][l]=x;
                }
                y = 1;
            }
            else i++;
        }
        return a;
    }
    public static double [] [] subtraction (double [][] a, int j)
    {
        int n = a.length;
        double x;
        for (int i=j;i<n;i++)
            if (i>j)
            {
                x=a[i][j]/a[j][j];
                for (int l=j;l<n;l++)
                    a[i][l]-=x*a[j][l];
            }
        return a;
    }
    public static double detA (double [][] a)
    {
        double det = 1;
        int n = a.length;
        for (int i=0;i<n;i++)
            det*=a[i][i];
        return det;
    }

}