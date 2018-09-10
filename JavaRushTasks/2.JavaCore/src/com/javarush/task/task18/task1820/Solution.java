package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        ArrayList<Float> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        FileOutputStream out = new FileOutputStream(file2);
        String s=in.readLine();
        String[] array = s.split("\\s");
        for (String str : array) {
            list.add(Float.parseFloat(str));
        }
        for (Float f : list) {
            out.write(String.valueOf(Math.round(f)).getBytes());
            out.write(" ".getBytes());
        }
        reader.close();
        in.close();
        out.close();
    }
}
