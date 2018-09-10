package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object obj =  objectStream.readObject();
            if (obj instanceof B) {
                return null;
            }
            return (A) obj;
        } catch (Exception e) {
            System.out.println("It is not A");
            e.printStackTrace();
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException {
       /* A a = new A();
        B b = new B();
        OutputStream outputStream = new FileOutputStream("C:\\test.txt");
        InputStream inputStream = new FileInputStream("C:\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        ObjectInputStream in = new ObjectInputStream(inputStream);
        Solution solution = new Solution();
        out.writeObject(a);

        System.out.println(solution.getOriginalObject(in));
*/
    }
}
