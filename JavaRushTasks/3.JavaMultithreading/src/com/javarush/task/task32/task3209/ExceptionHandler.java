package com.javarush.task.task32.task3209;

/**
 * Created by Alexander on 27.04.2018.
 */
public class ExceptionHandler extends Exception {
    public static void log(Exception e) {
        System.out.println(e.toString());
    }
}
