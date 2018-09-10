package com.javarush.task.task18.task1828;

/* 
Прайсы 2
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
                while ((line = in.readLine()) != null) {
                    list.add(line);
                }
                in.close();
                //list.set(0, list.get(0).substring(1));
                int id = Integer.parseInt(args[1]);
            if (args[0].equals("-u")) {
                for (int i =0; i<list.size(); i++) {
                    String str = list.get(i).substring(0, 8).trim();
                    int idFile = Integer.parseInt(str);
                    if (idFile==id) {
                        list.set(i, String.format("%-8s", id) + String.format("%-30s", args[2]) + String.format("%-8s", args[3]) + String.format("%-4s", args[4]));
                    }
                }
            } else if (args[0].equals("-d")) {
                for (int i =0; i<list.size(); i++) {
                    String str = list.get(i).substring(0, 8).trim();
                    int idFile = Integer.parseInt(str);
                    if (idFile==id) {
                        list.remove(i);
                    }
                }
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (String s : list) {
                writer.write(s);
                writer.write("\r\n");
            }
            writer.close();
        }
    }
}
