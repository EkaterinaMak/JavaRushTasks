package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, newFile);
        try (FileWriter out = new FileWriter(newFile)) {
            TreeMap<String, String> map = new TreeMap<>();
            Solution solution = new Solution();
            solution.getFiles(map, path);

            for (Map.Entry<String, String> pair : map.entrySet()) {
                FileReader in = new FileReader(new File(pair.getValue() + "/" + pair.getKey()));
                while (in.ready()) {
                    int n = in.read();
                    out.write(n);
                }
                in.close();
                out.write("\n".toCharArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getFiles(TreeMap<String, String> map, File path) {
        if (path.isDirectory()) {
            for (File file : path.listFiles()) {
                getFiles(map, file);
            }
        } else {
            if (path.length() <= 50) {
                map.put(path.getName(), path.getParent());
            }
        }
    }
}
