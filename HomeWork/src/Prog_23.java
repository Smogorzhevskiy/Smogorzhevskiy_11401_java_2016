import java.util.*;
public class Prog_23 {
    public static double [] [] multiplication (double [][] a, double [][] b) // Умножение
    {
        int n = a.length;
        double [] [] c = new double [n] [n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
            {
                for (int l=0; l<n; l++)
                    c[i][j]+=a[i][l]*b[l][j];
            }
        return c;
    }

    public static double [] [] division (double [][] a, int x) //Деление
    {
        int n = a.length;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                a[i][j]/=x;
        return a;
    }

    public static double [] [] amount (double [][] a, double [][] b) // Сумма
    {
        int n = a.length;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
            {
                a[i][j]+=b[i][j];
            }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double eps = 1e-6;
        int x = 1;
        double [] [] a = new double [n] [n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                a[i][j]=sc.nextDouble();
        double [] [] p = a;
        double [] [] solution = new double [n] [n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                solution[i][j]=0;
        int f = 1;
        while (f == 1) {
            p = multiplication (p, a);
            p = division (p, x);
            x++;
            solution=amount(solution,p);
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (p[i][j] < eps)
                        f = 0;
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                System.out.print(solution[i][j]+" ");
            System.out.println();
        }
    }
}