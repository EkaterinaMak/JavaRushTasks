package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {

        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        boolean containsPartOfName = true;
        boolean containsMax = true;
        boolean containsMin = true;

        if (partOfName!=null && !file.getFileName().toString().contains(partOfName)) {
            containsName=false;
        }

        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if (minSize!=0 && content.length<minSize) {
            containsMin=false;
        }

        if (maxSize!=0 && content.length>maxSize) {
            containsMax=false;
        }

        String contentString = new String(content);

        if (partOfContent!=null && !contentString.contains(partOfContent)) {
            containsPartOfName=false;
        }
        if (containsMax && containsMin && containsName && containsPartOfName) {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
