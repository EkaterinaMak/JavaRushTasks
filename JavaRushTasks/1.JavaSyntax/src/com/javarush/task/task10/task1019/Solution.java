package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            int id;
            String name;
            String s;
            s=reader.readLine();
            if (s.equals(""))
                break;
            id= Integer.parseInt(s);
            s=reader.readLine();
            if (s.equals(""))
                break;
            name = s;
            map.put(name, id);
        }
        for (Map.Entry m : map.entrySet()) {
            System.out.println( m.getValue() + " " + m.getKey());
        }
    }
}
