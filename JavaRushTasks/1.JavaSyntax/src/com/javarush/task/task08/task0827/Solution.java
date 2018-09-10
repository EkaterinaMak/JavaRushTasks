package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

       /* SimpleDateFormat dt = new SimpleDateFormat("MMM d yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt.parse(date));

        int days = cal.get(Calendar.DAY_OF_YEAR);
*/
        SimpleDateFormat sd = new SimpleDateFormat("D"); //здесь "D" даёт день с начала года.
        int days = Integer.parseInt(sd.format(new Date(date)));

        if (days%2!=0) {
            return true;
        } else {
            return false;
        }
/*
        String[] date1 = date.split(" ");
        int month=0;
        if (date1[0].equals("JANUARY"))
            month=0;
        if (date1[0].equals("February"))
            month=1;
        if (date1[0].equals("March"))
            month=2;
        if (date1[0].equals("April"))
            month=3;
        if (date1[0].equals("May"))
            month=4;
        if (date1[0].equals("June"))
            month=5;
        if (date1[0].equals("July"))
            month=6;
        if (date1[0].equals("August"))
            month=7;
        if (date1[0].equals("September"))
            month=8;
        if (date1[0].equals("October"))
            month=9;
        if (date1[0].equals("November"))
            month=10;
        if (date1[0].equals("December"))
            month=11;


        Date newDate = new Date();
        newDate.setYear(Integer.parseInt(date1[2]));
        newDate.setDate(Integer.parseInt(date1[1]));
        newDate.setMonth(month);

        Date year = new Date();
        year.setMinutes(0);;
        year.setHours(0);
        year.setSeconds(0);
        year.setMonth(0);;
        year.setDate(1);
        year.setYear(newDate.getYear());

        long distance = newDate.getTime()-year.getTime();
        long dayTime = 24*60*60*1000;
        int day = (int) Math.ceil((double)distance/(double)dayTime);
        boolean flag =true;
        if (day%2!=0) {
            flag=true;
        } else {
            flag=false;
        }

        return flag;*/
    }
}
