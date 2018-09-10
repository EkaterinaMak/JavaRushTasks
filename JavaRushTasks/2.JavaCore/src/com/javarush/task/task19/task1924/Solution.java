package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader in = new FileReader(file);
        String s="";
        while (in.ready()) {
            char c = (char) in.read();
            s += c;
        }
        in.close();
        String[] str = s.split("\\n");
        ArrayList<String> list = new ArrayList<>();
        for (String c : str) {
            list.add(c);
        }
        for (int i = 0; i<list.size(); i++) {
            for (Integer key : map.keySet()) {
                list.set(i, list.get(i).replaceAll("\\b" + key + "\\b", map.get(key)));
            }
        }
        for (String line : list) {
            System.out.println(line);
        }
    }
}
