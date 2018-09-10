package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandFather1 = new Human("Вася", true, 57);
        Human grandFather2 = new Human("Павел", true, 61);
        Human granny1 = new Human("Катя", false, 55);
        Human granny2 = new Human("Таня", false, 60);

        Human father = new Human("Михаил", true, 33, grandFather1, granny2);
        Human mother = new Human("Аня", false, 30, grandFather2, granny1);

        Human child1 = new Human("Игорь", true, 2, father, mother);
        Human child2 = new Human("Маша", false, 4, father, mother);
        Human child3 = new Human("Саша", true, 6, father, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(granny1.toString());
        System.out.println(granny2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















