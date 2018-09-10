package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        HashMap<Integer, String> map = new HashMap<>();
        while (in.ready()) {
            String s = in.readLine();
            String[] str = s.split("\\s");
            map.put(Integer.parseInt(str[0]), s);
        }
        in.close();
        reader.close();
        int id = Integer.parseInt(args[0]);
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            if (id == pair.getKey()) {
                System.out.println(pair.getValue());
            }
        }
    }
}
