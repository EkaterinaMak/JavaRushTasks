package com.javarush.task.task14.task1408;

/**
 * Created by Alexander on 01.09.2017.
 */
public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
