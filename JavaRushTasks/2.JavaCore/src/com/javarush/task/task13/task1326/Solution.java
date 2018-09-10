package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        InputStream in = new FileInputStream(name);
        BufferedReader f = new BufferedReader(new InputStreamReader(in));
        ArrayList<Integer> list = new ArrayList<>();
        while (f.ready()) {
            String s=f.readLine();
            if (s!=null) {
                int n = Integer.parseInt(s);
                list.add(n);
            }
        }
        for (int i = 0; i<list.size();) {
            if (list.get(i)%2!=0) {
                list.remove(i);
            } else
                i++;
        }

        int tmp;
        for (int i = 0; i<list.size(); i++) {
            for (int j=0; j<list.size()-1; j++) {
                if (list.get(j+1)<list.get(j)) {
                    tmp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1, tmp);
                }
            }
        }
        for (Integer n : list) {
            System.out.println(n);
        }
        in.close();
        f.close();
        // напишите тут ваш код
    }
}
