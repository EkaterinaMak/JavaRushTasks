package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by Alexander on 16.05.2018.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
