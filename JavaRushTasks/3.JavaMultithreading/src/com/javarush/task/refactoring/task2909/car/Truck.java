package com.javarush.task.refactoring.task2909.car;

/**
 * Created by Alexander on 12.02.2018.
 */
public class Truck extends Car {
    public static final int MAX_TRUCK_SPEED = 80;

    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
