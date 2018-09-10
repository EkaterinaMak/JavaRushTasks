package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int n1 = 0;
        int n2 = 0;

        if (a>0 && a!=0) {
            n1++;
        } else {
            if (a<0 && a!=0)
                n2++;
        }
        if (b>0 && b!=0) {
            n1++;
        } else {
            if (b<0 && b!=0)
                n2++;
        }
        if (c>0 && c!=0) {
            n1++;
        } else {
            if (c<0 && c!=0)
                n2++;
        }
        System.out.println("количество отрицательных чисел: " + n2);
        System.out.println("количество положительных чисел: " + n1);//напишите тут ваш код

    }
}
