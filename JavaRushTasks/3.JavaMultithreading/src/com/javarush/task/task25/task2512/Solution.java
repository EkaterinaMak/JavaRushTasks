package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<String> result = new ArrayList<>();
        Throwable throwable = e.fillInStackTrace();
        result.add(throwable.toString());
        while (true) {
            if (throwable.getCause()==null) {
                break;
            }
            throwable = throwable.getCause();
            result.add(0, throwable.toString());
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

    }
}
