package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
            char[] line = args[0].toCharArray();
            if (args[0].length() <= 255) {
                for (char a : line) {
                    if (!alphabet.contains(String.valueOf(a).toLowerCase())) {
                        System.out.println("incorrect");
                        return;
                    }
                }
            } else {
                System.out.println("incorrect");
            }
            for (int i = 2; i <= 36; i++) {
                try {
                    BigInteger bigInteger = new BigInteger(args[0], i);
                    System.out.println(i);
                    break;
                } catch (NumberFormatException e) {

                }
            }
        } catch (Exception e) {

        }
        //напишите тут ваш код
    }
}