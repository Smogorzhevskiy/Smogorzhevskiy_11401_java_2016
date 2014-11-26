import java.io.*;                           // Если вводим 25, то 1 число будет равно 62, второе 84 и т.д.
import java.util.*;
public class Prog_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число:");
        int x = sc.nextInt();
        System.out.print("Введите номер последнего считываемого числа:");
        int m = sc.nextInt();
        int n = 0 ;

        for (int i=0; i<m; i++) {
            int p=x*x;
            while (p > 0) {
                p /= 10;
                n++;
            }
            if (n % 2==1){                                        // Если кол-во цифр в числе нечетное, то мы делаем
                n++;}                                             // это кол-во четным.
            x= ((x * x)% (int)Math.pow(10 ,(n - (n / 2) + 1)));   // Провожу отбрасывание первых чисел
            x=(x/ (int)Math.pow(10 ,(n - (n / 2) -1)));           // и последних. С помощщью выведенной формулы.
            n=0;
        }
        System.out.print(x);

    }
}