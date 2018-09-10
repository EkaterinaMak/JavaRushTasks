package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream in2 = new FileInputStream(file2);
        FileInputStream in3 = new FileInputStream(file3);
        FileOutputStream out = new FileOutputStream(file1);
        while (in2.available()>0){
            out.write(in2.read());
        }
        while (in3.available()>0){
            out.write(in3.read());
        }
        in2.close();
        in3.close();
        out.close();
    }
}
