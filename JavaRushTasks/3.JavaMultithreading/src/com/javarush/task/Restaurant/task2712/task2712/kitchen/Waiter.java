package com.javarush.task.Restaurant.task2712.task2712.kitchen;

import com.javarush.task.Restaurant.task2712.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alexander on 11.05.2018.
 */
public class Waiter implements Observer
{
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o);
    }
}
