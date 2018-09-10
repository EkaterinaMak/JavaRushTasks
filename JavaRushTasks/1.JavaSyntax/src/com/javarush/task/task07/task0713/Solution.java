package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();
        for (int i=0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i< list.size(); i++) {
            if ((list.get(i)%3==0) || (list.get(i)%2==0)) {
                if (list.get(i) % 3 == 0)
                    list3.add(list.get(i));
                if (list.get(i)%2==0)
                    list2.add(list.get(i));
            } else {
                listOther.add(list.get(i));
            }
        }
        printList(list3);
        printList(list2);
        printList(listOther);
        //напишите тут ваш код
    }

    public static void printList(List<Integer> list) {
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
