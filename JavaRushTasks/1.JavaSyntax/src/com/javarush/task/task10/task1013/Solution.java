package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private boolean sex;
        private String education;
        private Human mother;
        private String job;

        public Human (String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human (String name, int age, boolean sex, String education) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.education = education;
        }
        public Human (String name, int age, boolean sex, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
        }
        public Human (String name, int age, String job, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.job = job;
        }
        public Human (String name, int age, String education, String job, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.education = education;
            this.job = job;
        }
        public Human (String name, int age, boolean sex, Human mother, String education) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.education = education;
            this.mother = mother;
        }
        public Human (String name, int age, boolean sex, String job, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.job = job;
        }
        public Human (String name, int age, boolean sex, String job, Human mother, String education) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.job = job;
            this.education=education;
        }
        public Human (String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
        public Human (String name, boolean sex, Human mother) {
            this.name = name;
            this.sex = sex;
            this.mother = mother;
        }
        // напишите тут ваши переменные и конструкторы
    }
}
