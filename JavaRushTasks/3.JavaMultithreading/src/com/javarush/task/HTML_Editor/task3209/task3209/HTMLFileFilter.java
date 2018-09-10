package com.javarush.task.HTML_Editor.task3209.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Alexander on 04.05.2018.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if (file.isDirectory() || file.getName().toLowerCase().endsWith(".html") || file.getName().toLowerCase().endsWith(".htm"))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
