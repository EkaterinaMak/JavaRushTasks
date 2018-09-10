package com.javarush.task.Restaurant.task2712.task2712.kitchen;

import com.javarush.task.Restaurant.task2712.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alexander on 21.05.2018.
 */
public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        Dish[] allDihes = Dish.values();
        for (int i = 0; i<(int)(Math.random()*Dish.values().length); i++) {
            dishes.add(allDihes[(int) (Math.random()*Dish.values().length)]);
        }
    }
}
