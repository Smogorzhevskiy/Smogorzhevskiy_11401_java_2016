import java.io.*;
import java.util.*;
public class Prog_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int s = 0, n;
        for ( int i=1; i<=x; i++){
            n = sc.nextInt();
            s+=n*n;
        }
        System.out.println(s);
    }
}
