package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file= reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String s = "";
        while (in.ready()) {
            s+=in.readLine()+" ";
        }
        in.close();
        String[] array = s.split("\\s");
        ArrayList<String> list = new ArrayList<>();
        for (String line : array) {
            list.add(line);
        }
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder(list.get(i));
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).equals(sb.reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first=list.get(i);
                    pair.second=list.get(j);
                    result.add(pair);
                    list.remove(j);
                    list.remove(i);
                    i--;
                    break;
                }
            }

        }
        result.size();
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
