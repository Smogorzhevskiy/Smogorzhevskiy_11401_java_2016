package com.company;
import java.util.*;
public class P1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите координаты, через пробел:");
        double x=sc.nextDouble();
        double y=sc.nextDouble();
        if ((x*x+y*y)<=1&&(y>=x-1)&&(y<=-x+1))
            System.out.print("Точка принадлежит заштриховнной области");
        else
            System.out.print("Точка не принадлежит заштрихованной области");

    }
}