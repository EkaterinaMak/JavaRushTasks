package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

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
        for (String c : str) {
            if (c.matches(".+\\d+") || c.matches("\\d+.+")) {
                out.write(c + " ");
            }
        }
        out.close();
    }
}
