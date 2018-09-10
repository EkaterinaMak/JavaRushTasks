package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        FileReader in = new FileReader(file1);
        String s="";
        while (in.ready()) {
            char c = (char) in.read();
            s += c;
        }
        in.close();
        String[] str = s.replaceAll("\\r\\n", " ").split("\\s");
        FileWriter out = new FileWriter(file2);
        String output="";
        for (String c : str) {
            if (c.length()>6) {
                output+=c + " ";
            }
        }
        out.write(output.trim().replaceAll("\\s", ","));
        out.close();
    }
}
