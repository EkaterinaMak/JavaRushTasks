package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader(args[0]);
        String s="";
        while (in.ready()) {
            char c = (char) in.read();
            s += c;
        }
        in.close();
        String[] str = s.split("\\n");
        for (String line : str) {
            String[] data = line.split("\\s");
            int year = Integer.parseInt(data[data.length-1]);
            int month = Integer.parseInt(data[data.length-2]);
            int day = Integer.parseInt(data[data.length-3]);
            String name ="";
            for (int i = 0; i<data.length-3; i++) {
                name+=data[i] + " ";
            }
            Date date = new Date(year-1900, month-1, day);
            PEOPLE.add(new Person(name.trim(), date));
        }

    }
}
