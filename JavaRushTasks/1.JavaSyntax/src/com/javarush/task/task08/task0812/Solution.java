package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       ArrayList<Integer> list = new ArrayList<>();
       for (int i= 0; i< 10; i++) {
           list.add(Integer.parseInt(reader.readLine()));
       }
        LinkedList<Integer> list2 = new LinkedList<>();
       int count =1;
       int n=list.get(0);
       for (int i=1; i<10; i++) {
           if (list.get(i) == n) {
               count++;
           } else {
               list2.add(count);
               n=list.get(i);
               count=1;
           }
       }
       list2.add(count);
       int max=list2.get(0);
       for (int i = 1; i< list2.size(); i++) {
           if (list2.get(i) > max) {
               max = list2.get(i);
           }
       }
        System.out.println(max);
       //напишите тут ваш код

    }
}