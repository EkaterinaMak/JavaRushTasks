package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s="";
            if (this.fileScanner.hasNext()) {
                s = this.fileScanner.next();
            }
            String[] data = s.split("\\s");
            Person person = new Person(data[1], data[2], data[0], new Date(Integer.parseInt(data[5]), Integer.parseInt(data[4])-1, Integer.parseInt(data[3])));
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
