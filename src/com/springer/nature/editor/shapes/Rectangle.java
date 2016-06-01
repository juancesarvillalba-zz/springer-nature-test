package com.springer.nature.editor.shapes;

import com.springer.nature.editor.constants.Constants;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class Rectangle extends ComplexShape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private Line topBorder;
    private Line leftBorder;
    private Line bottonBorder;
    private Line rigthBorder;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        topBorder = new Line(x1, y1, x2, y1, Constants.CHAR_X);
        leftBorder = new Line(x1, y1, x1, y2, Constants.CHAR_X);
        bottonBorder = new Line(x1, y2, x2, y2, Constants.CHAR_X);
        rigthBorder = new Line(x2, y1, x2, y2, Constants.CHAR_X);
        getShapes().add(topBorder);
        getShapes().add(leftBorder);
        getShapes().add(bottonBorder);
        getShapes().add(rigthBorder);
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
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
}
