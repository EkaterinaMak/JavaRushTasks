package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] list = new ArrayList[3];
        list[0]=new ArrayList<String>();
        list[1]=new ArrayList<String>();
        list[2]=new ArrayList<String>();
        list[0].add("qwe");
        list[0].add("rty");
        list[0].add("uio");
        list[1].add("asd");
        list[1].add("fgh");
        list[1].add("jkl");
        list[2].add("zxc");
        list[2].add("vbn");
        list[2].add("mlp");

        //напишите тут ваш код

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}