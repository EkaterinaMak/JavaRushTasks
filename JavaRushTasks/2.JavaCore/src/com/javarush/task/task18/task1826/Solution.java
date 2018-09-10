package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        if (args[0].equals("-e")) {
            ArrayList<Byte> list = new ArrayList<>();
            FileInputStream in = new FileInputStream(fileName);
            while (in.available()>0) {
                byte[] buffer = new byte[in.available()];
                in.read(buffer);
                for (byte b : buffer) {
                    list.add(b);
                }
            }
            in.close();
            String s="";
            for (byte b : list) {
                s+=String.valueOf(b)+" ";
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutputName)));
            writer.write(s);
            writer.close();
        } else if (args[0].equals("-d")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String s = "";
            while (reader.ready()) {
                s+=reader.readLine();
            }
            reader.close();
            String[] str = s.split("\\s");
            byte[] buffer = new byte[str.length];
            for (int i = 0; i<str.length; i++) {
                buffer[i] = Byte.parseByte(str[i]);
            }
            FileOutputStream out = new FileOutputStream(fileOutputName);
            out.write(buffer);
            out.close();
        }

    }

}
