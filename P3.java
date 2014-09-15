package com.company;
import java.io.*;
import java.util.*;
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0, a = 1, b = 1, e = 0;
        while (i < n - 2) {
            e = a + b;
            b = a;
            a = e;
            i++;
        }

        System.out.print(e);
    }
}

