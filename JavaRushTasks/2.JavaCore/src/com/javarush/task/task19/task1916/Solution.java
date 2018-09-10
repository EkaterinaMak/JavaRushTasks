package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        String s1 = "";
        String s2 = "";
        FileReader in1 = new FileReader(file1);
        FileReader in2 = new FileReader(file2);
        while(in1.ready()) {
            char c = (char) in1.read();
            s1+=c;
        }
        in1.close();
        while(in2.ready()) {
            char c = (char) in2.read();
            s2+=c;
        }
        in2.close();
        String[] str1 = s1.replaceAll("\\r", "").split("\\n");
        String[] str2 = s2.replaceAll("\\r", "").split("\\n");
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : str1) {
            list1.add(s);
        }
        for (String s : str2) {
            list2.add(s);
        }
        if (list1.size()>=list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                    try {
                        if (list1.get(i).equals(list2.get(0))) {
                            lines.add(new LineItem(Type.SAME, list1.get(i)));
                            list2.remove(0);
                        } else if (list1.get(i).equals(list2.get(1))) {
                            lines.add(new LineItem(Type.ADDED, list2.get(0)));
                            list2.remove(0);
                            i--;
                        } else {
                            lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        }
                    } catch (IndexOutOfBoundsException e) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    }
            }
        } else {
            for (int i= 0; i<list2.size(); i++) {
                try {
                    if (list2.get(i).equals(list1.get(0))) {
                        lines.add(new LineItem(Type.SAME, list2.get(i)));
                        list1.remove(0);
                    } else if (list2.get(i).equals(list1.get(1))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                        list1.remove(0);
                        i--;
                    } else {
                        lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    }
                } catch (IndexOutOfBoundsException e) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                }
            }
        }

//lines.get(0);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
