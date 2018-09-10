package com.javarush.task.HTML_Editor.task3209.task3209.actions;

import com.javarush.task.HTML_Editor.task3209.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Alexander on 03.05.2018.
 */
public class RedoAction extends AbstractAction {
    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}
