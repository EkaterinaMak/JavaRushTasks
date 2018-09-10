package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream in = new FileInputStream(name);
        int min=127;
        while (in.available()>0) {
            int b=in.read();
            if (b<min) {
                min=b;
            }
        }
        System.out.println(min);
        reader.close();
        in.close();
    }
}
