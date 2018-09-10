package com.javarush.task.refactoring.task2909.human;

/**
 * Created by Alexander on 12.02.2018.
 */
public class Soldier extends Human {
    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
            fight();
    }

    public void fight() {
    }

}
