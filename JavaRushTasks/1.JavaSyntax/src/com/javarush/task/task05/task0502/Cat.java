package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
       int n1, n2;
       boolean flag = true;
       n1 = this.age + this.strength + this.weight;
       n2 = anotherCat.age + anotherCat.strength + anotherCat.weight;
       if (n1 > n2) {
           flag = true;//напишите тут ваш код
       } else {
           if (n2 > n1)
               flag = false;
       }
       return flag;
    }

    public static void main(String[] args) {

    }
}
