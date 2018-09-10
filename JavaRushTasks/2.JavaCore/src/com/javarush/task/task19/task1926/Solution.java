package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader in = new FileReader(file);
        String s="";
        while (in.ready()) {
            char c = (char) in.read();
            s+= c;
        }
        in.close();
        String[] str = s.split("\\n");
        for (String c : str) {
            StringBuilder sb = new StringBuilder(c);
            System.out.println(sb.reverse().toString());
        }

    }
}
