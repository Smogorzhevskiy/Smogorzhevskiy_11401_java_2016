package com.company;
import java.io.*;
import java.util.*;
public class P5 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
          int x = sc.nextInt();
        int n=0;
        while (x>0)
        {
            n = n + (x % 10);
            x = x / 10;

        }
        System.out.print(n);


    }
}
