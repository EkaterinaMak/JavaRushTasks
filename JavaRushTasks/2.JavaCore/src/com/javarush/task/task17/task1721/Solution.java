package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1 = reader.readLine();
            String name2 = reader.readLine();

            BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(name1)));
            BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(name2)));

            while (fileReader1.ready()) {
                allLines.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                forRemoveLines.add(fileReader2.readLine());
            }
            reader.close();
            fileReader1.close();
            fileReader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public  void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines=new ArrayList<>();
            throw new CorruptedDataException();
        }
    }
}
