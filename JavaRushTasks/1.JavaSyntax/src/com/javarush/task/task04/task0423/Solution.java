package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int n = Integer.parseInt(reader.readLine());

        if (n > 20)
            System.out.println("И 18-ти достаточно");//напишите тут ваш код
    }
}
