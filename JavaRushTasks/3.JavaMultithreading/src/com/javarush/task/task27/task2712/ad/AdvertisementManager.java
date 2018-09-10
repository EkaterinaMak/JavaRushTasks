package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Alexander on 11.05.2018.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().size()==0) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> startList = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                startList.add(advertisement);
            }
        }
        List<List<Advertisement>> lists = recursion(startList);
        if (lists.size()==1 && lists.get(0).size()==0) {
            throw new NoVideoAvailableException();
        }
        for (int i = 0; i < lists.size();) {
            int duration=0;
            for (Advertisement advertisement : lists.get(i)) {
                duration+=advertisement.getDuration();
            }
            if (duration>timeSeconds) {
                lists.remove(i);
            } else {
                i++;
            }
        }

        Collections.sort(lists, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                long max1=0;
                long max2=0;
                for (Advertisement advertisement : o1) {
                    max1+=advertisement.getAmountPerOneDisplaying();
                }
                for (Advertisement advertisement : o2) {
                    max2+=advertisement.getAmountPerOneDisplaying();
                }
                if (max1 < max2) {
                    return 1;
                } else if (max1>max2) {
                    return -1;
                } else if (max1==max2) {
                    int time1 = 0;
                    int time2 = 0;
                    for (Advertisement advertisement : o1) {
                        time1+=advertisement.getDuration();
                    }
                    for (Advertisement advertisement : o2) {
                        time2+=advertisement.getDuration();
                    }
                    if (time1<time2) {
                        return 1;
                    } else if (time1>time2) {
                        return -1;
                    } else if (time1==time2) {
                        if (o1.size()>o2.size()) {
                            return 1;
                        } else if (o1.size()<o2.size()) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });

        List<Advertisement> list = lists.get(0);
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying()<o2.getAmountPerOneDisplaying()) {
                    return 1;
                } else if (o1.getAmountPerOneDisplaying()>o2.getAmountPerOneDisplaying()) {
                    return -1;
                } else if (o1.getAmountPerOneDisplaying()==o2.getAmountPerOneDisplaying()) {
                    if (o1.getAmountPerOneDisplaying()/o1.getDuration() > o2.getAmountPerOneDisplaying()/o2.getDuration()) {
                        return 1;
                    } else if (o1.getAmountPerOneDisplaying()/o1.getDuration() < o2.getAmountPerOneDisplaying()/o2.getDuration()) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        long amount = 0;
        int totalDuration = 0;
        for (Advertisement advertisement : list) {
            amount+=advertisement.getAmountPerOneDisplaying();
            totalDuration+=advertisement.getDuration();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(list,amount, totalDuration));
        for (Advertisement advertisement : list) {
            double priceForSecond = (double) advertisement.getAmountPerOneDisplaying()/ (double) advertisement.getDuration();
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() + ", " + (long)(priceForSecond*1000));
            advertisement.revalidate();
        }



    }

    private List<List<Advertisement>> recursion(List<Advertisement> originalList) {
        List<List<Advertisement>> lists = new ArrayList<List<Advertisement>>();
        if (originalList.isEmpty() || originalList==null) {
            lists.add(new ArrayList<Advertisement>());
            return lists;
        }

        List<Advertisement> list = new ArrayList<Advertisement>(originalList);
        Advertisement head = list.get(0);
        List<Advertisement> rest = new ArrayList<Advertisement>(list.subList(1, list.size()));
        for (List<Advertisement> set : recursion(rest)) {
            List<Advertisement> newSet = new ArrayList<Advertisement>();
            newSet.add(head);
            newSet.addAll(set);
            lists.add(newSet);
            lists.add(set);
        }

        return lists;
    }
}
