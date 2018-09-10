package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args.length!=0) {
            ArrayList<String> list = new ArrayList<>();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            while ((line=in.readLine()) != null) {
                list.add(line);
            }
            in.close();
            int max = 0;
            //list.set(0, list.get(0).substring(1));
            for (String s : list) {
                String str = s.substring(0, 8).trim();
                int id = Integer.parseInt(str);
                if (id>max) {
                    max = id;
                }
            }
            int id = max+1;
            list.add(String.format("%-8s", id) + String.format("%-30s", args[1]) + String.format("%-8s", args[2]) + String.format("%-4s", args[3]));

           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (String s : list) {
                writer.write(s);
                writer.write("\r\n");
            }
            writer.close();
        }
    }
}
