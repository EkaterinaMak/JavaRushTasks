package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i < 10; i++) {
            list.add(reader.readLine());
        }
        String min = list.get(0);
        String max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > max.length())
                max = list.get(i);
            if (list.get(i).length() < min.length())
                min = list.get(i);
        }
        for (int i =0; i<list.size(); i++) {
            if (list.get(i).length() == min.length()) {
                System.out.println(list.get(i));
                break;
            }
            if (list.get(i).length() == max.length()) {
                System.out.println(list.get(i));
                break;
            }
        }
        //напишите тут ваш код
    }
}
