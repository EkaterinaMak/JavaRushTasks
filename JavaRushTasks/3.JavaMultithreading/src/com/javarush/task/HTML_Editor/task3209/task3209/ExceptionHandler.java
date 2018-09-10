package com.javarush.task.HTML_Editor.task3209.task3209;

/**
 * Created by Alexander on 27.04.2018.
 */
public class ExceptionHandler extends Exception {
    public static void log(Exception e) {
        e.printStackTrace();
        System.out.println(e.toString());
    }
}
