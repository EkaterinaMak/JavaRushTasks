package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] array = s.split("\\b");
        for (int i =0; i< array.length; i++) {
            String f = array[i].substring(0,1);
            String l = array[i].substring(1);
            array[i]=f.toUpperCase().concat(l);
        }
        String output = array[0];
        for (int i = 1; i<array.length; i++) {
            output=output + array[i];
        }
        System.out.println(output);

        //напишите тут ваш код
    }
}
