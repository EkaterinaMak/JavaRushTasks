package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        Person person = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        switch (args[0]) {
            case "-c" :
                try {
                    if (args[2].equals("м")) {
                        person=Person.createMale(args[1], sd.parse(args[3]));
                    } else {
                        person=Person.createFemale(args[1], sd.parse(args[3]));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                break;

            case "-u" :
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else {
                    person.setSex(Sex.FEMALE);
                }
                try {
                    person.setBirthDay(sd.parse(args[4]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                allPeople.set(Integer.parseInt(args[1]),person);
                break;

            case "-d" :
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setBirthDay(null);
                person.setSex(null);
                allPeople.set(Integer.parseInt(args[1]),person);
                break;

            case "-i" :
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " + format.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
                break;

                default:
                    break;
        }
        //start here - начни тут
    }
}
