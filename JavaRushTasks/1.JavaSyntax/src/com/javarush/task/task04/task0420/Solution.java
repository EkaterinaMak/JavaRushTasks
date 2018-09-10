package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

       int n1, n2, n3;
        if (a >= b) {
            n1 = a;
            if (a >= c) {
                if ( b >= c) {
                    n2 = b;
                    n3 = c;
                } else {
                    n2 = c;
                    n3 = b;
                }
            } else {
                n1 = c;
                n2 = a;
                n3 = b;
            }
        } else {
            n1 = b;
            if ( b >= c) {
                if (a >= c) {
                    n2 = a;
                    n3 = c;//напишите тут ваш код
                } else {
                    n2 = c;
                    n3 = a;
                }
            } else {
                n1 = c;
                n2 = b;
                n3 = a;
            }
        }
        System.out.println(n1 + " " + n2 + " " + n3);
    }
}
