package com.javarush.task.Restaurant.task2712.task2712.kitchen;

/**
 * Created by Alexander on 08.05.2018.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int time) {
        duration=time;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        for (Dish d : Dish.values()) {
            sb.append(d.name());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length()-1);
        return sb.toString();
    }
}
