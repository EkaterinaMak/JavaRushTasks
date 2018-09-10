package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        String fileName ="";
        while (true) {
            String s =reader.readLine();
            if (s.equals("end"))
                break;
            String[] str = s.split("\\.part");
            fileName=str[0];
            map.put(Integer.parseInt(str[1])-1, s);
        }
        /*char[] array = list.get(0).toCharArray();
        ArrayList<Character> listChar = new ArrayList<>();
        for (char c : array)
            listChar.add(c);
        for(int i = array.length-1; i>=0; i--) {
            if (array[i]!='\\') {
                listChar.remove(i);
            } else {
                break;
            }
        }
        String path = listChar.toString();
        */
        File file = new File(fileName);
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            FileInputStream in = new FileInputStream(pair.getValue());
            while (in.available()>0) {
                byte[] buffer = new byte[in.available()];
                int count = in.read(buffer);
                out.write(buffer, 0, count);
            }
            in.close();
        }
        out.close();
        reader.close();
    }
}
