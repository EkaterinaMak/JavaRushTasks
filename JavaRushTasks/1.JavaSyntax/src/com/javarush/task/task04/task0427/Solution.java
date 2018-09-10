package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s = reader.readLine();
       int n = Integer.parseInt(s);

       if (n > 0 && n < 1000){
           if (n%2==0 && s.length()==1)
               System.out.println("четное однозначное число");
           if (n%2!=0 && s.length()==1)
               System.out.println("нечетное однозначное число");
           if (n%2==0 && s.length()==2)
               System.out.println("четное двузначное число");
           if (n%2!=0 && s.length()==2)
               System.out.println("нечетное двузначное число");
           if (n%2==0 && s.length()==3)
               System.out.println("четное трехзначное число");
           if (n%2!=0 && s.length()==3)
               System.out.println("нечетное трехзначное число");
           //напишите тут ваш код
       }

    }
}
