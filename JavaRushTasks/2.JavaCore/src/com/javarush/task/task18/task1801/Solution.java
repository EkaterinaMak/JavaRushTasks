package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream in = new FileInputStream(name);
        int max=0;
        while (in.available()>0) {
            int b=in.read();
            if (b>max) {
                max=b;
            }
        }
        System.out.println(max);
        reader.close();
        in.close();
    }
}
