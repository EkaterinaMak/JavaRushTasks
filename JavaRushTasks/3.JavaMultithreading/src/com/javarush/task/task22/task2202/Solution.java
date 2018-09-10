package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string==null || string.split("[ ]+").length<5)
            throw new TooShortStringException();

        int start = string.indexOf(" ") +1;
        while (string.charAt(start) == ' ') {
            start++;
        }
        int count = 1;
        int end = start+1;
        while (count<4) {
            while (string.charAt(end) != ' ') {
                end++;
            }
            if (string.charAt(end-1) != ' ')
                count++;
            end++;
        }
        while ((string.charAt(end) != ' ') && (string.charAt(end) != '\t')) {
            end++;
            if (end==string.length()-1) {
                end++;
                break;
            }
        }

        return string.substring(start, end);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
