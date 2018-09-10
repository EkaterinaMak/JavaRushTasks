package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();

            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
      /*  FileOutputStream fileOutput = new FileOutputStream("C:\\test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutput);
        Person person = new Person("Ivan", "Ivanov", "Russia", Sex.MALE);

        oos.writeObject(person);
        fileOutput.close();
        oos.close();

        FileInputStream fiStream = new FileInputStream("C:\\test.txt");
        ObjectInputStream ois = new ObjectInputStream(fiStream);

        Person person1 = (Person) ois.readObject();

        fiStream.close();
        ois.close();
        System.out.println(person.equals(person1));
        */
    }
}
