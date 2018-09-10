package com.javarush.task.Restaurant.task2712.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 18.05.2018.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits()>=1) {
                list.add(advertisement);
            }
        }
        return list;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits()==0) {
                list.add(advertisement);
            }
        }
        return list;
    }
}
