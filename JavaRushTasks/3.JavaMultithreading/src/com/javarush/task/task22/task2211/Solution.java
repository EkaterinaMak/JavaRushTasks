package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        in.close();
        String s = new String(buffer, Charset.forName("Windows-1251"));
        buffer = s.getBytes(Charset.forName("UTF-8"));
        FileOutputStream out = new FileOutputStream(args[1]);
        out.write(buffer);
        out.close();
    }
}
