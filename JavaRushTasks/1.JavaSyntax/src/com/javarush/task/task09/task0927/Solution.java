package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> map = new HashMap<>();
        map.put("Vaska", new Cat("Vaska"));
        map.put("Semen", new Cat("Semen"));
        map.put("Barsik", new Cat("Barsik"));
        map.put("Murzik", new Cat("Murzik"));
        map.put("Musya", new Cat("Musya"));
        map.put("Masya", new Cat("Masya"));
        map.put("Hvost", new Cat("Hvost"));
        map.put("Sima", new Cat("Sima"));
        map.put("Mashka", new Cat("Mashka"));
        map.put("Ryzhik", new Cat("Ryzhik"));

        return map;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        HashSet<Cat> set = new HashSet<>();
        set.addAll(map.values());
        return set;
        //напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
