package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String file="";
        while (in.ready()) {
            file+= in.readLine();
        }
        int count=0;
        String al = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i <al.length(); i++) {
            list.add(al.charAt(i));
        }
        char[] content = file.toCharArray();
        for (Character c : content) {
            if (list.contains(Character.toLowerCase(c))) {
                count++;
            }
        }
        System.out.println(count);
        in.close();

    }
}
