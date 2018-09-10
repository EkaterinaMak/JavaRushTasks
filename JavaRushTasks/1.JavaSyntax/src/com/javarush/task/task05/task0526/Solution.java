package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Vasya", 30, "Lenina 23");
        Man man2 = new Man("Sasha", 40, "Gagarina 1");
        Woman woman1 = new Woman("Lena", 20, "Rodionova 3");
        Woman woman2 = new Woman("Anya", 25, "Bogdanovicha 5");
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);

        //напишите тут ваш код
    }

    public static class Man {
        private String name;
        private int age;
        private String address;

        Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        private String name;
        private int age;
        private String address;

        Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }//напишите тут ваш код

}
