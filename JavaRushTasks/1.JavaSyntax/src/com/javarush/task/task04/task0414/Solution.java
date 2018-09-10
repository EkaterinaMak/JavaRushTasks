package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int a = Integer.parseInt(s);

        if ((a%4 == 0) && !((a%100 == 0) && (a%400 != 0))) {
            System.out.println("количество дней в году: 366");//напишите тут ваш код
        } else {
            System.out.println("количество дней в году: 365");
        }
    }
}