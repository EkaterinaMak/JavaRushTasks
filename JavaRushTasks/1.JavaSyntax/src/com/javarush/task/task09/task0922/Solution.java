package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Date date = new Date(s);
       // SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");


       // Date date = sd.parse(s);
        SimpleDateFormat form = new SimpleDateFormat("MMM d, yyyy", Locale.forLanguageTag("en_US"));


        System.out.println( form.format(date).toUpperCase());

        //напишите тут ваш код
    }
}
