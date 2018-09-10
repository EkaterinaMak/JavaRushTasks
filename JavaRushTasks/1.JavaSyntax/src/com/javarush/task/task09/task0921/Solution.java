package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> ar= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                ar.add(Integer.parseInt(reader.readLine()));
            }
        } catch (NumberFormatException e) {
            for (int i = 0; i < ar.size(); i++) {
                System.out.println(ar.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //напишите тут ваш код
    }
}
