package com.javarush.task.Restaurant.task2712.task2712.kitchen;

import com.javarush.task.Restaurant.task2712.task2712.ConsoleHelper;
import com.javarush.task.Restaurant.task2712.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexander on 08.05.2018.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.size()==0) {
            return "";
        }
        return "Your order: " + dishes.toString() +
                " of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
    }

    public int getTotalCookingTime() {
        int totalTime = 0;
        for (Dish d : dishes) {
            totalTime+= d.getDuration();
        }
        return totalTime;
    }

    public boolean isEmpty() {
        if (dishes.size() == 0) {
            return true;
        }
        return false;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        dishes= ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }
}
