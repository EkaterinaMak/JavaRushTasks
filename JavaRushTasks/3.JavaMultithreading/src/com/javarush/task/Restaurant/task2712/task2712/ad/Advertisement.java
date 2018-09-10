package com.javarush.task.Restaurant.task2712.task2712.ad;

/**
 * Created by Alexander on 11.05.2018.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        try {
            amountPerOneDisplaying=initialAmount/hits;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits<=0) {
            throw new UnsupportedOperationException();
        }
        hits-=1;
    }

    public int getHits() {
        return hits;
    }
}
