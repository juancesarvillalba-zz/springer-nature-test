package com.springer.nature.editor.canvas;

import com.springer.nature.editor.commands.ICommand;

/**
 * Created by juanvillalba on 1/06/16.
 */
public interface ICanvas {

    void render();

    void setElement(int x1, int i, char x);

    IArea getArea();

    int getWidth();

    int getHeight();

    Character getElement(int x, int y);

    boolean addCommand(ICommand command);
}
