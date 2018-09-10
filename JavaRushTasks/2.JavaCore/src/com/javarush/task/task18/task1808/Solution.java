package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        FileInputStream in = new FileInputStream(name1);
        FileOutputStream out2 = new FileOutputStream(name2);
        FileOutputStream out3 = new FileOutputStream(name3);
        int size;
        if (in.available()>0) {
            if (in.available()%2==0) {
                size=in.available()/2;
            } else {
                size = in.available()/2+1;
            }
            byte[] buffer = new byte[size];
            in.read(buffer);
            out2.write(buffer);
            int count = in.read(buffer);
            out3.write(buffer, 0, count);
        }
        reader.close();
        in.close();
        out2.close();
        out3.close();
    }
}
