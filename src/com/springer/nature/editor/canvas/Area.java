package com.springer.nature.editor.canvas;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class Area implements IArea {

    private int width;

    private int height;

    private char[][] area;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
        this.area = new char[height][width];
        this.initArea();
    }

    private void initArea() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = ' ';
            }
        }
    }

    @Override
    public void setElement(int col, int row, char element) {
        // user inputs are non-zero base
        col = col - 1;
        row = row - 1;
        if (col >= 0 && col < width && row >= 0 && row < height) {
            area[row][col] = element;
        }
    }

    @Override
    public Character getElement(int col, int row) {
        col = col - 1;
        row = row - 1;
        if (col >= 0 && col < width && row >= 0 && row < height) {
            return area[row][col];
        }
        return ' ';
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
