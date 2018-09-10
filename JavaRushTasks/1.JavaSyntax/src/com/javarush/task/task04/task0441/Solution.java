package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a == b && b == c && c == a) {
            System.out.println(a);//напишите тут ваш код
        } else {
            if (a == b )
                System.out.println(a);
            if (b == c )
                System.out.println(b);
            if (c == a )
                System.out.println(c);
        }

            if ((a < b && b < c) || (c <b && b<a))
                System.out.println(b);
            if ((b < c && c < a) || (a<c && c<b))
                  System.out.println(c);
            if ((c < a && a < b) || (b<a && a<c))
                  System.out.println(a);


    }
}
