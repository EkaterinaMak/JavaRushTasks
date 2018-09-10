package com.javarush.task.task14.task1421;

/**
 * Created by Alexander on 06.09.2017.
 */
public class Singleton {

    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {
    }
}
