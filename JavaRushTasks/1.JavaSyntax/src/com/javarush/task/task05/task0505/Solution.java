package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
       Cat cat1 = new Cat("Vaska", 3, 3, 5);
       Cat cat2 = new Cat("Barsik", 4, 4, 6);
       Cat cat3 = new Cat("Semen", 7, 6, 6);

        System.out.println(cat1.name + " победил " + cat2.name + " - " + cat1.fight(cat2));
        System.out.println(cat2.name + " победил " + cat3.name + " - " + cat2.fight(cat3));
        System.out.println(cat3.name + " победил " + cat1.name + " - " + cat3.fight(cat1));
       //напишите тут ваш код
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
