package com.javarush.task.Restaurant.task2712.task2712;

import com.javarush.task.Restaurant.task2712.task2712.ad.Advertisement;
import com.javarush.task.Restaurant.task2712.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.Restaurant.task2712.task2712.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alexander on 16.05.2018.
 */
public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<String, Double> map = StatisticManager.getInstance().getAdvertisementProfit();
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        List<Date> list = new ArrayList<>();
        for (String s : map.keySet()) {
            try {
                list.add(df.parse(s));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        double totalAmount = 0;
        for (Date date : list) {
            ConsoleHelper.writeMessage(df.format(date) + " - " + String.format(Locale.ENGLISH, "%.2f", map.get(df.format(date))/100));
            totalAmount+=map.get(df.format(date))/100;
        }
        ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH, "%.2f", totalAmount));
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getCookWorkloading();
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        List<Date> list = new ArrayList<>();
        for (String s : map.keySet()) {
            try {
                list.add(df.parse(s));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(list);
        Collections.reverse(list);

        for (Date date : list) {
            String d = df.format(date);
            ConsoleHelper.writeMessage(d);
            List<String> names = new ArrayList<>(map.get(d).keySet());
            Collections.sort(names);
            for (String name : names) {
                int time = map.get(d).get(name);
                int min;
                if (time%60==0) {
                    min = time/60;
                } else {
                    min = time/60 + 1;
                }
                ConsoleHelper.writeMessage(name + " - " + min + " min");
            }
            ConsoleHelper.writeMessage("");
        }


    }

    public void printActiveVideoSet() {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement a : list) {
            ConsoleHelper.writeMessage(a.getName() + " - " + a.getHits());
        }

    }

    public void printArchivedVideoSet() {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getArchivedVideoSet();
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement a : list) {
            ConsoleHelper.writeMessage(a.getName());
        }
    }
}
