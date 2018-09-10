package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();

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
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int n = pair.getKey();
            System.out.println((char)n + " " + pair.getValue());
        }
    /*    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String s= "";
        while (in.ready()) {
             s += in.readLine();
        }
        in.close();
        char[] array = s.toCharArray();
        HashMap<Character, Integer> mapChar = new HashMap<>();
        for (char c : array) {
            int value;
            if (mapChar.containsKey(c)) {
                value=mapChar.get(c);
                mapChar.put(c, value+1);
            } else {
                mapChar.put(c, 1);
            }
        }
        byte[] arr = new byte[mapChar.size()];
        int iter = 0;
        for (Character key : mapChar.keySet()) {
            byte[] codes = String.valueOf(key).getBytes("ascii");
            arr[iter]=codes[0];
            iter++;
        }

        for (int i = 1; i<arr.length; i++) {
            for (int j = 0; j <arr.length-1; j++) {
                if (arr[j]>arr[j+1]) {
                    byte tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        for (int i=0; i<arr.length; i++) {
            char c = (char)arr[i];
            for (Character key : mapChar.keySet()) {
                if (c == key) {
                    System.out.println(key + " " + mapChar.get(key) + " " +arr[i]);
                }
            }
        }
*/
    }
}
