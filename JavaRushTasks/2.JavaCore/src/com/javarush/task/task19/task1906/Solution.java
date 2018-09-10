package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader in = new FileReader(file1);
        FileWriter out = new FileWriter(file2);
        int count=1;
        while (in.ready()) {
            int data = in.read();
            if (count%2==0) {
                out.write(data);
            }
            count++;
        }
        in.close();
        out.close();
    }
}
