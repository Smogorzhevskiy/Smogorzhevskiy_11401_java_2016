import java.util.*;

public class Prog_25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();
        System.out.println("Введите левую и правую границы первого подмассива массива а : ");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        System.out.println("Введите левую и правую границы второго подмассива массива а : ");
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        System.out.println("Введите левую и правую границы подмассива массива b: ");
        int l3 = sc.nextInt();
        int r3 = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        System.out.println("Заполните массив а : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Заполните массив  b: ");
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        mergeSort(a, l1, r2);
        finalMerge(a, b, l1, r1, l2, r2, l3);
        for (int i = 0; i < n; i++)
            System.out.print(b[i] + " ");
    }

    public static int[] merge(int[] a, int l1, int r1, int l2, int r2, int[] temp) {
        int n = r1 - l1 + 1, m = r2 - l2 + 1;
        int i, j, k, u;
        int[] b = new int[n];
        int[] c = new int[m];

        for (i = 0, u = l1; i < n; i++, u++)
            b[i] = a[u];
        for (j = 0, u = l2; j < m; j++, u++)
            c[j] = a[u];
        i = 0;
        j = 0;
        k = 0;
        while ((i < n) && (j < m)) {
            if (b[i] < c[j]) {
                temp[k] = b[i];
                i++;
                k++;
            } else {
                temp[k] = c[j];
                j++;
                k++;
            }
        }

        while (i < n) {
            temp[k] = b[i];
            i++;
            k++;
        }
        while (j < m) {
            temp[k] = c[j];
            j++;
            k++;
        }
        return temp;
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int[] temp = new int[r - l + 1];
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            temp = merge(a, l, m, m + 1, r, temp);
            for (int i = 0; i <= r - l; i++)
                a[i + l] = temp[i];
        }
    }

    public static void finalMerge(int a[], int b[], int l1, int r1, int l2, int r2, int l3) {
        int i, j, k;
        for (i = l1, j = l3; i <= r1; i++, j++)
            b[j] = a[i];
        k = j;
        for (i = l2, j = k; i <= r2; i++, j++)
            b[j] = a[i];
    }


}