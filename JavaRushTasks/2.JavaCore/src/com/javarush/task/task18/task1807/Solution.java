package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
        ArrayList<String> list = new ArrayList<>();
        while (in.ready()) {
            list.add(in.readLine());
        }
        reader.close();
        in.close();
        int count=0;
        for (String s : list) {
           byte[] codes = s.getBytes("ascii");
           for (int i = 0; i< codes.length; i++) {
               if (codes[i]==44)
                   count++;
           }

        }
        System.out.println(count);
    }
}
