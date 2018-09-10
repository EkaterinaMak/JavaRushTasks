package com.javarush.task.Restaurant.task2712.task2712;

import com.javarush.task.Restaurant.task2712.task2712.kitchen.Cook;
import com.javarush.task.Restaurant.task2712.task2712.kitchen.Order;
import com.javarush.task.Restaurant.task2712.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Alexander on 08.05.2018.
 */
public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        cook.setQueue(orderQueue);
        Cook cook2 = new Cook("Homa");
        cook2.setQueue(orderQueue);
        Thread tCook = new Thread(cook);
        Thread tCook2 = new Thread(cook2);
        tCook.setDaemon(true);
        tCook2.setDaemon(true);
        tCook.start();
        tCook2.start();

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 1; i <=5 ; i++) {
            tabletList.add(new Tablet(i));
            tabletList.get(i-1).setQueue(orderQueue);
        }

       cook.addObserver(new Waiter());
        cook2.addObserver(new Waiter());
        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }

}
