package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
/*
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(this.getI(), this.getJ());
        } */
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {

                 throw new CloneNotSupportedException();

        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }

    public static void main(String[] args) {
        B b = new B(1,2,"fee");
        B clone = null;
        try {
            clone = b.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
