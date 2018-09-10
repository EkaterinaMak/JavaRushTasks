package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/


public class Dog {
    private String name, color;
    private int height;

    public Dog(String name) {
        this.name = name;
    }//напишите тут ваш код


    public Dog(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public Dog(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }


    public static void main(String[] args) {

    }
}
