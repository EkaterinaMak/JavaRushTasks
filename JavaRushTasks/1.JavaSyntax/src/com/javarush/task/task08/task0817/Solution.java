package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Макаренкова", "Екатерина");
        map.put("Петров", "Александр");
        map.put("Егоров", "Александр");
        map.put("Иванов", "Татьяна");
        map.put("Кротова", "Наталья");
        map.put("Сидоров", "Анна");
        map.put("Соколов", "Юрий");
        map.put("Трегубова", "Антонина");
        map.put("Морозов", "Юрий");
        map.put("Репейников", "Анна");
        return map;

        //напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashSet<String> list = new HashSet<>();
        String name, key;
        for (Map.Entry<String, String> s : map.entrySet()) {
            name=s.getValue();
            key=s.getKey();
            for (Map.Entry<String, String> s1 : map.entrySet()) {
                if (s1.getValue().equals(name) && !s1.getKey().equals(key)) {
                    list.add(name);
                }
            }
        }

        for (String s : list) {
            removeItemFromMapByValue(map, s);
        }


        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
