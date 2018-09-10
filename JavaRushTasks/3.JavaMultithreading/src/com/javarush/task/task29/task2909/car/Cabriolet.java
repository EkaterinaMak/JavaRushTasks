package com.javarush.task.task29.task2909.car;

/**
 * Created by Alexander on 12.02.2018.
 */
public class Cabriolet extends Car {
    public static final int MAX_CABRIOLET_SPEED = 90;

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
