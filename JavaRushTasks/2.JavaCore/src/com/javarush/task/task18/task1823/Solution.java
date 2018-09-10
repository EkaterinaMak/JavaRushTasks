package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) {
                break;
            }
            list.add(s);
        }
        reader.close();
        for (String file : list) {
            new ReadThread(file).start();
        }

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
            //implement constructor body
        }

        @Override
        public void run() {
            try {
                FileInputStream in = new FileInputStream(this.getName());
                HashMap<Integer, Integer> map = new HashMap<>();
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
                in.close();
                int max=0;
                for (Integer values : map.values()) {
                    if (values>max) {
                        max=values;
                    }
                }
                for (Map.Entry<Integer, Integer> pairs : map.entrySet()) {
                    if (pairs.getValue()==max) {
                        resultMap.put(this.getName(), pairs.getKey());
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
