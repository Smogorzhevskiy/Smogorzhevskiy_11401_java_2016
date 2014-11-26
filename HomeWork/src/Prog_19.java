import java.io.*;
import java.util.*;
public class Prog_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] a = new int [6][6];
        for (int  i = 0; i<6; i++)
        {
            System.out.println();
            for (int j=0; j<6; j++)
            {
                if ((i<3) && (j<3)) {
                    if (i > j)
                        a[i][j] = i + 1;
                    else a[i][j] = j + 1;
                }
                if (((i<3) && (j>=3)) || ((i>=3) && (j<3)))
                    a[i][j]=4;
                if ((i>=3) && (j>=3))
                    a[i][j]=i+j-1;

                System.out.print(a[i][j]+" ");
            }

        }
    }
}