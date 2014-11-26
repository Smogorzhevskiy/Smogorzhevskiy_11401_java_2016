
import java.util.*;
public class Prog_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите координаты, через пробел:");
        double x=sc.nextDouble();
        double y=sc.nextDouble();
        if ((x*x+y*y)<1&&(y>x-1)&&(y<-x+1))
            System.out.print("Точка принадлежит области");
        else
            System.out.print("Точка не принадлежит области");

    }
}