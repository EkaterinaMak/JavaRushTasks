package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander on 08.05.2018.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        writeMessage("Выберите блюдо: " + Dish.allDishesToString());
        String dish;
        while ((dish = readString()) != null) {
            if (dish.equals("exit"))
                break;
            if (!Dish.allDishesToString().contains(dish)) {
                writeMessage(dish + " - нет в меню");
            } else {
                list.add(Dish.valueOf(dish));
            }
        }
        return list;
    }
}
