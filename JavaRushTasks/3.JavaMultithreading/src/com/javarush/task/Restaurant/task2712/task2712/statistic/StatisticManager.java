package com.javarush.task.Restaurant.task2712.task2712.statistic;

import com.javarush.task.Restaurant.task2712.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.Restaurant.task2712.task2712.statistic.event.EventDataRow;
import com.javarush.task.Restaurant.task2712.task2712.statistic.event.EventType;
import com.javarush.task.Restaurant.task2712.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alexander on 16.05.2018.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

    public Map<String, Double> getAdvertisementProfit() {
        Map<String, Double> map = new HashMap<>();
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);

        List<EventDataRow> list = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        for (EventDataRow eventDataRow : list) {
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            if (map.keySet().contains(df.format(videoSelectedEventDataRow.getDate()))) {
                map.put(df.format(videoSelectedEventDataRow.getDate()), map.get(df.format(videoSelectedEventDataRow.getDate())) + videoSelectedEventDataRow.getAmount());
            } else {
                map.put(df.format(videoSelectedEventDataRow.getDate()), (double) videoSelectedEventDataRow.getAmount());
            }
        }
        return map;
    }

    public Map<String, Map<String, Integer>> getCookWorkloading() {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);

        List<EventDataRow> list = statisticStorage.getStorage().get(EventType.COOKED_ORDER); {
            for (EventDataRow eventDataRow : list) {
                CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
                if (map.keySet().contains(df.format(cookedOrderEventDataRow.getDate()))) {
                    if (map.get(df.format(cookedOrderEventDataRow.getDate())).keySet().contains(cookedOrderEventDataRow.getCookName())) {
                        map.get(df.format(cookedOrderEventDataRow.getDate())).put(cookedOrderEventDataRow.getCookName(), map.get(df.format(cookedOrderEventDataRow.getDate())).get(cookedOrderEventDataRow.getCookName())+ cookedOrderEventDataRow.getTime());
                    } else {
                        map.get(df.format(cookedOrderEventDataRow.getDate())).put(cookedOrderEventDataRow.getCookName(), cookedOrderEventDataRow.getTime());
                    }
                } else {
                    map.put(df.format(cookedOrderEventDataRow.getDate()), new HashMap<>());
                    map.get(df.format(cookedOrderEventDataRow.getDate())).put(cookedOrderEventDataRow.getCookName(), cookedOrderEventDataRow.getTime());
                }
            }
        }

        return map;
    }
}
