package com.company;
import java.io.*;
import java.util.*;
public class P6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        double eps=1e-6, p=x*x,s=x*x;
        int k=1;
        while (p>eps){
            p/=k;
            s+=p;
            k++;
        }

        System.out.print(s);
    }
}
