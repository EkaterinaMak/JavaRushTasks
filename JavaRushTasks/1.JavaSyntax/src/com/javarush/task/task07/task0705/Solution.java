package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int[] big = new int[20];
       for (int i = 0; i<big.length; i++) {
           big[i]=Integer.parseInt(reader.readLine());//напишите тут ваш код
       }
       int[] first = new int[10];
       int[] second = new int[10];
       for (int i = 0; i<first.length; i++) {
           first[i]=big[i];
       }
       int j = 10;
       for (int i=0; i<second.length; i++) {
           second[i]=big[j];
           j++;
       }
       for (int i =0; i<second.length; i++) {
           System.out.println(second[i]);
       }
    }
}
