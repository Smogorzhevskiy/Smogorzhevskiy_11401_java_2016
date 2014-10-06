import java.util.*;
public class Prog_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int [] a = new int [x];
        int max, maxim;
        int k=0;
        for (int i=0; i<x; i++)
            a[i]=sc.nextInt();
        max=a[0];
        maxim=max;
        for (int i=1; i<x; i++){
            if (a[i]>max) {
                maxim=max;
                max = a[i];
                k=1;
            }
            else
                 if (a[i]>maxim) {
                 maxim = a[i];
                 k=1;
            }
            else
                 if (a[i]==maxim)
                 k++;
        }
        System.out.println(k);
    }
}
