package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int radix=10;
        if (s.startsWith("0x")) {
            radix=16;
            s=s.replaceAll("0x", "");
        } else if (s.startsWith("0b")) {
            radix=2;
            s=s.replaceAll("0b", "");
        } else if (s.startsWith("0")) {
            radix=8;
            s=s.replaceAll("0", "");
        }
        s=String.valueOf(Integer.parseInt(s, radix));
        //напишите тут ваш код
        return s;
    }
}
