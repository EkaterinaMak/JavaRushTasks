package com.javarush.task.task05.task0529;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int n = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     while (true) {
         String s = reader.readLine();
         if (s.equals("сумма"))
             break;
         int a = Integer.parseInt(s);
         n = n+a;
     }
        System.out.println(n);
        //напишите тут ваш код
    }
}
