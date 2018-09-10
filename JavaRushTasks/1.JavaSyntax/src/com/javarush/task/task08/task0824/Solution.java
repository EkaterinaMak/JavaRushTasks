package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human children1 = new Human("Vasya", true, 10, new ArrayList<Human>());
        Human children2 = new Human("Semen", true, 6, new ArrayList<Human>());
        Human children3 = new Human("Maria", false, 2, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<>();
        children.add(children1);
        children.add(children2);
        children.add(children3);
        Human mother = new Human("Nataliya", false,35, children);
        Human father = new Human("Mikhail", true,36, children);
        ArrayList<Human> child1 = new ArrayList<>();
        child1.add(mother);
        ArrayList<Human> child2 = new ArrayList<>();
        child2.add(father);
        Human grandMother1 = new Human("Tatiyana", false, 60, child1);
        Human grandFather1 = new Human("Dmitriy", true, 60, child1);
        Human grandMother2 = new Human("Marina", false, 61, child2);
        Human grandFather2 = new Human("Ivan", true, 63, child2);

        System.out.println(children1.toString());
        System.out.println(children2.toString());
        System.out.println(children3.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandFather1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(grandFather2.toString());

        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;


        Human (String name, boolean sex, int age, ArrayList<Human> children) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }

        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
