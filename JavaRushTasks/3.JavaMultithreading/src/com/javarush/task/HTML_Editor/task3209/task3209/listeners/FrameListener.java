package com.javarush.task.HTML_Editor.task3209.task3209.listeners;

import com.javarush.task.HTML_Editor.task3209.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Alexander on 27.04.2018.
 */
public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }
}
