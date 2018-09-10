package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();

        set.add(3);
        set.add(2);
        set.add(7);
        set.add(22);
        set.add(34);
        set.add(5);
        set.add(6);
        set.add(8);
        set.add(9);
        set.add(0);
        set.add(66);
        set.add(88);
        set.add(56);
        set.add(45);
        set.add(12);
        set.add(10);
        set.add(23);
        set.add(67);
        set.add(1);
        set.add(4);
        return set;
        //напишите тут ваш код

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        HashSet<Integer> set1 = new HashSet<>();

        for (int n : set) {
            if (n <= 10)
                set1.add(n);
            //напишите тут ваш код
        }
        return set1;

    }

    public static void main(String[] args) {

    }
}
