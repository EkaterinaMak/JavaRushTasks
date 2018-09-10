package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int i = 0;
       double n = 0.0, s = 0;
       while (true) {
          int a = Integer.parseInt(reader.readLine());
          if (a == -1)
              break;
          s = s + a;
          i++;//напишите тут ваш код
       }
       if (i == 0) {
           System.out.println(0.0);
       } else {
           n = s/i;
           System.out.println(n);
       }
    }
}

