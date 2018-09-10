package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       int n = 0;
       while (true){
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           int i = Integer.parseInt(reader.readLine());
           n = n+i;
           if (i == -1)
               break;

       }
        System.out.println(n);
        //напишите тут ваш код
    }
}
