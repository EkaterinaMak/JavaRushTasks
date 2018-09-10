package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
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
        map.put("Соколов", "Дмитрий");
        map.put("Трегубова", "Антонина");
        map.put("Морозов", "Юрий");
        map.put("Репейников", "Алена");
        return map;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int countName=0;
        for (Map.Entry<String, String> s : map.entrySet()) {
            if (s.getValue().equals(name)) {
                countName++;
            }
        }
        return countName;
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int countSurname=0;
        for(Map.Entry<String, String> s : map.entrySet()) {
            if (s.getKey().equals(lastName)) {
                countSurname++;
            }
        }
        return countSurname;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
