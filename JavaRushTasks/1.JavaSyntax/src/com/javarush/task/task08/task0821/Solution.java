package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "Sergey");
        map.put("Ivanov", "Semen");
        map.put("Sidorov", "Andrey");
        map.put("Petrov", "Andrey");
        map.put("Smith", "John");
        map.put("Morozov", "Alexandr");
        map.put("Smith", "Jack");
        map.put("Popov", "Evgeny");
        map.put("Rybakov", "Alexandr");
        map.put("Belov", "Roman");

        //напишите тут ваш код

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
