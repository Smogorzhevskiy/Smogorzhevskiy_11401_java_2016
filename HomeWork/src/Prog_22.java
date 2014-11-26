
import java.util.*;

public class Prog_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int up = 0, down = n - 1,left = 0,right = n - 1, x=1;
        while (up<=down){
            for (int j=left; j<=right; j++) {
                a[up][j] = x;
                x++;
            }
            up++;
            for (int i=up; i<=down; i++){
                a[i][right]=x;
                x++;
            }
            right--;
            for (int j=right; j>=left; j--){
                a[down][j]=x;
                x++;
            }
            down--;
            for (int i=down; i>=up; i--){
                a[i][left]=x;
                x++;
            }
            left++;
        }
        for (int i=0; i<n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j]+" ");
        }
    }
}