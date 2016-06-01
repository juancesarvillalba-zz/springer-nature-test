package com.springer.nature.editor.commands;

import com.springer.nature.editor.canvas.ICanvas;
import com.springer.nature.editor.constants.Constants;

/**
 * In charge of parsing arguments and execute flood fill algorithm
 *
 * Created by juanvillalba on 1/06/16.
 */
public class DrawBucketFillCommand extends Command {

    private int x1;
    private int y1;
    private char color;

    public DrawBucketFillCommand(String[] commandArguments) {
        super(Constants.BUCKET_FILL_COMMAND);
        this.x1 = Integer.parseInt(commandArguments[0]);
        this.y1 = Integer.parseInt(commandArguments[1]);
        this.color = commandArguments[2].charAt(0);
    }

    public void draw(ICanvas canvas) {
        doBucketFill(canvas, x1, y1, color);
    }


    public void doBucketFill(ICanvas canvas, int col, int row, char color) {
        if (Constants.CHAR_X.equals(canvas.getElement(col, row)) || canvas.getElement(col, row).equals(color)) {
            return;
        }
        if (col >= 1 && col < canvas.getWidth() + 1 && row >= 1 && row < canvas.getHeight() + 1) {
            if (Character.isSpaceChar(canvas.getElement(col, row))) {
                canvas.setElement(col, row, color);
            }
            doBucketFill(canvas, col - 1, row, color);
            doBucketFill(canvas, col + 1, row, color);
            doBucketFill(canvas, col, row - 1, color);
            doBucketFill(canvas, col, row + 1, color);
        }
    }
}
