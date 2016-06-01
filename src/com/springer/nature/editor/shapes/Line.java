package com.springer.nature.editor.shapes;

import com.springer.nature.editor.canvas.ICanvas;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class Line extends Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private char drawingChar;

    public Line(int x1, int y1, int x2, int y2 ,char drawingChar) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.drawingChar = drawingChar;
    }


    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void draw(ICanvas canvas) {
        if (isHorizontal()) {
            for (int i = getX1(); i <= getX2(); i++) {
                canvas.setElement(i, getY1(), drawingChar);
            }
        } else {
            for (int i = getY1(); i <= getY2(); i++) {
                canvas.setElement(getX1(), i, drawingChar);
            }
        }
    }

    private boolean isHorizontal() {
        return getY1() == getY2();
    }
}
