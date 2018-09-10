package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        ArrayList<Integer> list = new ArrayList<>();
        while (in.available()>0) {
            list.add(in.read());
        }
        for (int i = list.size()-1; i>=0; i--) {
            out.write(list.get(i));
        }
        reader.close();
        in.close();
        out.close();
    }
}
