package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null || string.contains("\t")==false)
            throw new TooShortStringException();

        int start = string.indexOf("\t") +1;
        while (string.charAt(start) == '\t') {
            start++;
        }
        int end = string.indexOf("\t", start);
        if (end==-1)
            throw new TooShortStringException();

        return string.substring(start, end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
