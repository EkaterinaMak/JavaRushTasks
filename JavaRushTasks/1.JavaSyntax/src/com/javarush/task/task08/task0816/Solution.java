package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Smith", new Date("JULY 4 1999"));
        map.put("Sidorov", new Date("SEPTEMBER 15 2000"));
        map.put("Petrov", new Date("JANUARY 30 2000"));
        map.put("Ivanov", new Date("FEBRUARY 20 1995"));
        map.put("Zaycev", new Date("JULY 5 1999"));
        map.put("Krotova", new Date("SEPTEMBER 25 2000"));
        map.put("Vasina", new Date("JANUARY 31 2000"));
        map.put("Zotova", new Date("FEBRUARY 10 1995"));
        map.put("Makarov", new Date("AUGUST 3 1980"));
        return map;


        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
        Map.Entry<String, Date> s=iterator.next();
            if (s.getValue().getMonth()==5 || s.getValue().getMonth()==6 || s.getValue().getMonth()==7) {
                iterator.remove();
            }
        }

        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
