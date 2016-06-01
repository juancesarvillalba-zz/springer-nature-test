package com.springer.nature.editor.commands;

import com.springer.nature.editor.constants.Constants;

/**
 * In charge of parsing arguments for creation of a Canvas.
 * Created by juanvillalba on 1/06/16.
 */
public class CreateCanvasCommand extends Command {

    private int width;
    private int height;

    public CreateCanvasCommand(String[] commandArguments) {
        super(Constants.CREATE_CANVAS_COMMAND);
        width = Integer.parseInt(commandArguments[0]);
        height = Integer.parseInt(commandArguments[1]);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
