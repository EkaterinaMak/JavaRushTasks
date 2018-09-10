package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream f = new FileInputStream("file.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] ar = null;
            int a = ar[0];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] ar = new int[1];
            ar[0] = 1;
            ar[2] = 2;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            int a = list.get(3);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer.parseInt("asdf");
        } catch (Exception e) {
            exceptions.add(e);
            //напишите тут ваш код
        }

        try {
            String s = "asdfg";
            char c = s.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Class.forName("dfgfggdgd");
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@serv1:1521:XE", "hr", "hr");
        } catch (SQLException e) {
            exceptions.add(e);
        }


        try {
            Method[] meth = Class.forName("java.lang.String").getClass().getMethods();
            for (Method m : meth) {

                    Class[] par = m.getParameterTypes();

                    Method method = Class.forName("java.lang.String").getClass().getMethod("homa", par);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            exceptions.add(e);
        }
    }
}
