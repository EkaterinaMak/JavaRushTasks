package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader(args[0]);
        String s="";
        while (in.ready()) {
            char c = (char) in.read();
            s += c;
        }
        in.close();
        String[] str = s.replaceAll("\\r\\n", " ").split("\\s");
        TreeMap<String, Double> map = new TreeMap<>();
        for (int i = 0; i < str.length; i+=2) {
            String name = str[i];
            double value = Double.parseDouble(str[i+1]);
            if (!map.containsKey(name)) {
                map.put(name, value);
            } else {
                map.put(name, map.get(name) + value);
            }
        }
        double max=0;
        for (Double d : map.values()) {
            if (d>max)
                max=d;
        }
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue()==max) {
                System.out.println(pair.getKey());
            }
        }
    }
}
