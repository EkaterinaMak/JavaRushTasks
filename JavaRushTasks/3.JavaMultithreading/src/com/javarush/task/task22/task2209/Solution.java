package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {

       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String file = reader.readLine();
           reader.close();
           BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
           String s = "";
           while (in.ready()) {
               s += in.readLine() + " ";
           }
           in.close();
           String[] array = s.split("\\s");

           StringBuilder sb = getLine(array);
           System.out.println(sb.toString());
           //...
           StringBuilder result = getLine();
           System.out.println(result.toString());
       }  catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static StringBuilder getLine(String... words) {
        if (words.length==0) {
            return new StringBuilder("");
        }
        ArrayList<String> list = new ArrayList<>();
        for (String line : words) {
            list.add(line);
        }
        Collections.sort(list);
        StringBuilder sb=new StringBuilder(list.get(0));
        int max=1;
        for (int i = 0; i < list.size(); i++)  {
            ArrayList<String> copy = new ArrayList<>(list);
            int count = 1;
            StringBuilder string = new StringBuilder(list.get(i));
            copy.remove(i);
            for (int j = 0; j < copy.size(); ) {
                if (string.charAt(string.length()-1)==copy.get(j).toLowerCase().charAt(0)) {
                    string.append(" " + copy.get(j));
                    count++;
                    copy.remove(j);
                    j=0;
                } else
                    j++;
            }
            if (count>max) {
                max=count;
                sb=string;
            }
        }
        if (list.size()>max) {
            for (String word : list) {
                if (!sb.toString().contains(word)) {
                    sb.append(" " + word);
                }
            }
        }
        return sb;
    }
}
