package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[10];
        int[] arr = new int[10];

        for (int i = 0; i<str.length; i++) {
            str[i] = reader.readLine();
            arr[i] = str[i].length();
        }

        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
       //напишите тут ваш код
    }
}
