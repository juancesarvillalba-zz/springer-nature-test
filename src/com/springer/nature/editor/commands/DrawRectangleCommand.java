package com.springer.nature.editor.commands;

import com.springer.nature.editor.canvas.ICanvas;
import com.springer.nature.editor.constants.Constants;
import com.springer.nature.editor.shapes.Rectangle;

/**
 * In charge of parsing arguments and create a Rectangle complex shape.
 * Created by juanvillalba on 1/06/16.
 */
public class DrawRectangleCommand extends Command {

    Rectangle rectangle;

    public DrawRectangleCommand(String[] commandArguments) {
        super(Constants.RECTANGLE_COMMAND);
        int x1 = Integer.parseInt(commandArguments[0]);
        int y1 = Integer.parseInt(commandArguments[1]);
        int x2 = Integer.parseInt(commandArguments[2]);
        int y2 = Integer.parseInt(commandArguments[3]);
        rectangle = new Rectangle(x1, y1, x2, y2);
    }

    public void draw(ICanvas canvas) {
        rectangle.draw(canvas);
    }
}
