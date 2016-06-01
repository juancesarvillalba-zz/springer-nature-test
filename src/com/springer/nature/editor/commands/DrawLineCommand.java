package com.springer.nature.editor.commands;

import com.springer.nature.editor.canvas.ICanvas;
import com.springer.nature.editor.constants.Constants;
import com.springer.nature.editor.shapes.Line;

/**
 * In charge of parsing arguments and create a Line shape.
 *
 * Created by juanvillalba on 1/06/16.
 */
public class DrawLineCommand extends Command {

    Line line;

    public DrawLineCommand(String[] commandArguments) {
        super(Constants.LINE_COMMAND);
        int x1 = Integer.parseInt(commandArguments[0]);
        int y1 = Integer.parseInt(commandArguments[1]);
        int x2 = Integer.parseInt(commandArguments[2]);
        int y2 = Integer.parseInt(commandArguments[3]);
        line = new Line(x1, y1, x2, y2, Constants.CHAR_X);
    }

    public void draw(ICanvas canvas) {
        line.draw(canvas);
    }
}
