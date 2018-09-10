package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String file="";
        while (in.ready()) {
            file+= in.readLine();
        }
        int count=0;

        char[] content = file.toCharArray();
        for (Character c : content) {
            if (c.equals(' ')) {
                count++;
            }
        }
        double n = (float)count/content.length*100;
        System.out.println(String.format("%(.2f", n));
        in.close();

    }
}
