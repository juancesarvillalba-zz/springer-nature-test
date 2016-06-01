package com.springer.nature.editor.shapes;

import com.springer.nature.editor.canvas.ICanvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanvillalba on 1/06/16.
 */
public abstract class ComplexShape extends Shape {

    List<IShape> shapes = new ArrayList<>();

    public List<IShape> getShapes() {
        return shapes;
    }

    public void setShapes(List<IShape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(ICanvas canvas) {
        for (IShape shape : shapes) {
            shape.draw(canvas);
        }
    }
}
