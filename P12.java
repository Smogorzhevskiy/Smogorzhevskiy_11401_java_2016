package com.company;
import  java.io.*;
import java.util.*;
public class P12 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите число в десятичной системе счисления:");
        int x=sc.nextInt();
        System.out.print("Введите степень, в которою хотите перевести:");
        int q=sc.nextInt();
        int n=0;
        int p=0;
        while (x>q){
            n=x%q;
            x/=q;
            p+=n;

        }
        p=p+x;
        System.out.print(p);
    }
}

