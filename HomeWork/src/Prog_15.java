import java.io.*;
import java.util.*;
public class Prog_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество чисел:");
        int k = sc.nextInt();
        System.out.println("Числа:");
        int number = sc.nextInt();
        int summa =0;
        k--;
        while (number>=0 && k!=0) {
            number = sc.nextInt();
            k--;
        }
        for (int i=1; i<=k; i++) {
            number = sc.nextInt();
            if (number % 2 == 0)
                summa+=number;
        }
        System.out.println(summa);
    }
}