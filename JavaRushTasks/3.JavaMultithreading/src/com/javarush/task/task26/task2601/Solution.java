package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer n : array) {
            list.add(n);
        }
        Integer m;
        if (array.length%2 !=0) {
            m = array[array.length/2];
        } else {
            m= (array[array.length/2 -1] + array[array.length/2])/2;
        }
        for (int i = 0; i < list.size(); i++) {
            int id=i;
            Integer delta = Math.abs(m-list.get(i));
            for (int j = i+1; j < list.size(); j++) {
                if (Math.abs(m-list.get(j))<delta) {
                    delta = Math.abs(m-list.get(j));
                    id = j;
                }
            }
            list.add(i, list.get(id));
            list.remove(id +1);
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=list.get(i);
        }
        //implement logic here
        return array;
    }
}
