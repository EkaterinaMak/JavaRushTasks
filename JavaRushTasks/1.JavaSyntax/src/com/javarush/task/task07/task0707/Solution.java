package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList();
        list.add("Katya");
        list.add("Sasha");
        list.add("Radiy");
        list.add("Homa");
        list.add("Pipa");
        System.out.println(list.size());
        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
