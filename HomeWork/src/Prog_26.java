import java.io.*;
import java.util.*;

public class Prog_26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] a = new int[x];
        for (int i = 0; i < x; i++)
            a[i] = sc.nextInt();
        quickSort(a, 0, x - 1);
        for (int i = 0; i < x; i++)
            System.out.print(a[i] + " ");
    }

    public static void quickSort(int a[], int l, int r) {
            int n = partition(a, l, r);
            if (l < n- 1)
                quickSort(a, l, n- 1);
            if (n < r)
                quickSort(a, n, r);
        }
    public static int partition(int a[], int l, int r) {
        int i = l, j = r;
        int x;
        int y = a[(l + r) / 2];

        while (i <= j) {
            while (a[i] < y)
                i++;
            while (a[j] > y)
                j--;
            if (i <= j) {
                x = a[i];
                a[i] = a[j];
                a[j] = x;
                i++;
                j--;
            }
        }

        return i;
    }




}