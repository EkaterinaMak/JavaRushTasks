package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] ar = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            ar[i] = reader.readLine();
        }

        for (int i = ar.length-1; i >=0; i--) {
            System.out.println(ar[i]);
        }
        //напишите тут ваш код
    }
}