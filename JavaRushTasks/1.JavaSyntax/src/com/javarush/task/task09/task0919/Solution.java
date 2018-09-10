package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
            e.printStackTrace();

        }
    }

        public static void divisionByZero() {
        System.out.println(15/0);
    }
}
