package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream in = new FileInputStream(name);
        HashSet<Integer> set = new HashSet<>();
        while (in.available()>0) {
            set.add(in.read());
        }
        Integer[] arr = set.toArray(new Integer[set.size()]);
        for (int i = 1; i<arr.length; i++) {
            for (int j = 0; j <arr.length-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        for (int m : arr) {
            System.out.print(m + " ");
        }
        reader.close();
        in.close();
    }
}
