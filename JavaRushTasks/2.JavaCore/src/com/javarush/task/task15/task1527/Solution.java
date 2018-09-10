package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String arg = null;
        ArrayList<String> param = new ArrayList<>();
        String[] substr = url.split("\\?");
        String[] subparams = substr[1].split("&");
        for (String s : subparams) {
            char[] ar = s.toCharArray();
            for (int i = 0; i< ar.length; i++) {
                if (ar[i]!='=') {
                    if (arg != null)
                        arg += ar[i];
                    else
                        arg=Character.toString(ar[i]);
                } else {

                    break;
                }
            }
            param.add(arg);
            arg = null;
        }
        for (String s : param) {
            System.out.print(s + " ");
        }
        System.out.println("");

        for (String s : subparams) {
            if (s.contains("obj")) {
                String obj = s.substring(4);
                try {
                    Double value = Double.parseDouble(obj);
                    alert(value);
                } catch (NumberFormatException e) {
                    alert(obj);
                }
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
