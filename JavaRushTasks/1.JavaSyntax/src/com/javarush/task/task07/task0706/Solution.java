package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dom =new int[15];
        for (int i=0; i<dom.length; i++) {
            dom[i]=Integer.parseInt(reader.readLine());
        }
        int chet=0, nechet=0;
        for(int i =0; i<dom.length;i+=2) {
            chet=chet+dom[i];
        }
        for (int i =1; i<dom.length; i+=2) {
            nechet+=dom[i];
        }
        if (chet>nechet) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
        //напишите тут ваш код
    }
}
