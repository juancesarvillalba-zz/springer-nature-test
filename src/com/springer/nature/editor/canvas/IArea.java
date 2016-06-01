package com.springer.nature.editor.canvas;

/**
 * Created by juanvillalba on 1/06/16.
 */
public interface IArea {

    void setElement(int col, int row, char e);

    Character getElement(int col, int row);

    int getWidth();

    int getHeight();
}
