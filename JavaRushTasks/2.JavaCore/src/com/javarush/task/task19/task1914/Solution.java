package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(stream);
        System.setOut(output);
        testString.printSomething();
        System.setOut(console);

        String s = stream.toString();
        String[] str = s.split("\\s");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[2]);
        int c=0;
        if (str[1].equals("+")) {
            c=a+b;
        } else if (str[1].equals("-")) {
            c=a-b;
        } else if (str[1].equals("*")) {
            c=a*b;
        }
        s = s.trim() + " " + c;
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

