package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader in = new FileReader(file);
        int count = 0;
        String s ="";
        while (in.ready()) {
            s +=(char)in.read();
        }
        in.close();
        Pattern p = Pattern.compile("\\bworld(\\p{Punct}|\\b)");
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
