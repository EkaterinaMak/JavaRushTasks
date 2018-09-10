package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        FileInputStream in = new FileInputStream(name);
        while (in.available()>0) {
            int n = in.read();
            int value;
            if (map.containsKey(n)) {
                value=map.get(n);
                map.put(n, value+1);
            } else {
                map.put(n, 1);
            }
        }
        int min=127;
        for (Integer values : map.values()) {
            if (values<min) {
                min=values;
            }
        }
        for (Map.Entry<Integer, Integer> pairs : map.entrySet()) {
            if (pairs.getValue()==min) {
                System.out.print(pairs.getKey() + " ");
            }
        }
        reader.close();
        in.close();
    }
}
