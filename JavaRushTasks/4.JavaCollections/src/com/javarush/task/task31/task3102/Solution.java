package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File path = new File(root);
        List<String> list = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();

        Collections.addAll(queue, path.listFiles());
        while (!queue.isEmpty()) {
            File tmp = queue.remove();
            if (tmp.isDirectory()) {
                Collections.addAll(queue, tmp.listFiles());
            } else {
                list.add(tmp.getAbsolutePath());
            }
        }
        return list;

    }

    public static void main(String[] args) {
        
    }
}
