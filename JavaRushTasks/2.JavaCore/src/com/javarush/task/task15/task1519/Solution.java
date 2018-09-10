package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s=reader.readLine();
            if (s.equals("exit"))
                break;
            try {
                if (s.contains(".")) {
                    print(Double.parseDouble(s));
                } else {
                    int n =Integer.parseInt(s);
                    if (n>0 && n < 128)
                        print((short) n);
                    else if (n<=0 || n >= 128)
                        print(n);
                }
            } catch (NumberFormatException e) {
                print(s);
            }

        }

        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
