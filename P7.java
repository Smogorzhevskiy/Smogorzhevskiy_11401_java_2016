package com.company;
import java.io.*;
import java.util.*;
public class P7 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        double s=x*x, p=x*x, e=1e-6;
        int k=2;
        while (p>e){
            p=p*(((k*x)/(k-1))/(k-1));
            k++;
            s+=p;
        }
        System.out.print(s);


    }
}
