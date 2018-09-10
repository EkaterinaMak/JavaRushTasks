package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));
        while (in.ready()) {
            String s = in.readLine();
            String[] str = s.split("\\s");
            for (String c : str) {
                if (c.matches("[-+]?\\d+")) {
                    out.write(c + " ");
                }
            }
        }
        in.close();
        out.close();
    }
}
