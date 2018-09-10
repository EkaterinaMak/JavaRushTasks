package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream in1 = new FileInputStream(file1);
        ArrayList<Integer> list = new ArrayList<>();
        while (in1.available()>0) {
            list.add(in1.read());
        }
        FileInputStream in2 = new FileInputStream(file2);
        FileOutputStream out = new FileOutputStream(file1);
        while (in2.available()>0) {
            out.write(in2.read());
        }
        for (Integer n : list) {
            out.write(n);
        }
        reader.close();
        in1.close();
        in2.close();
        out.close();
    }
}
