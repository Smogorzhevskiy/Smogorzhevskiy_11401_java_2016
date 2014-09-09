package com.company;
import java.io.*;
import java.util.*;
public class P2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        double y=1;
        if (x>5)
            y=x*x*x-1;
        else {
            if (x > 1 && x <= 5)
                y = 3 * x * x - 12 * x + 7;
            else {
                if (x <= 1)
                    y = Math.abs(x * x * x) - 2 * x;
            }
        }
        System.out.print("f(x)="+y);

    }

}