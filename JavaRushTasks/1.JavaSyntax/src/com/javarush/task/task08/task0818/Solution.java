package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Ivanov", 1000);
        map.put("Petrov", 500);
        map.put("Sidorov", 600);
        map.put("Smith", 700);
        map.put("Morozov", 300);
        map.put("Sokolov", 250);
        map.put("Goncharov", 800);
        map.put("Maximov", 100);
        map.put("Orlov", 900);
        map.put("Karasev", 2000);
        return  map;

        //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> s = iterator.next();
            if(s.getValue()<500 ) {
                iterator.remove();
            }
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}