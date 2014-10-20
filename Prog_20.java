import java.util.*;
public class Prog_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//  нужно вводить нечетное число
        int[][] a = new int[n][n];
        if (n%2==0)
            System.out.print("Попробуйте снова. Введите нечетное число");
        else
            for (int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i == j) || (i + j == n - 1))
                        a[i][j] = (n + 1) / 2;
                    else
                      if ((i > j) && (i + j > n - 1))
                         a[i][j] = i + 2;
                      else
                        if (i > j && i + j < n - 1)
                           a[i][j] = 1+(n + 1) / 2;
                        else
                          if (i < j && i + j > n - 1)
                             a[i][j] = 1+(n + 1) /2;
                          else
                            if (j <= (n - 1) / 2)
                               a[i][j] = (n + 1) / 2 - j + i;
                            else
                               a[i][j] = i + j + 1 - (n - 1) / 2;
                }
            }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}

