package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Path path = Paths.get(name);

        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
        } else {
            int countDirectories = 0;
            int countFiles = 0;
            long bytes = 0;


        }
    }
}
