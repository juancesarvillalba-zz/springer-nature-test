package com.springer.nature.editor.commands;

import com.springer.nature.editor.canvas.Canvas;
import com.springer.nature.editor.constants.Constants;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class DrawBucketFillCommandTests {

    public static final Character COLOR = '0';
    Canvas canvas = null;

    @Before
    public void setUp() {
        String[] commandLineArguments = {"20", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand);
    }

    @Test
    public void drawShouldFillAllCanvasWithOColor() {
        String[] commandLineArguments = {"2", "4", COLOR.toString()};
        DrawBucketFillCommand drawBucketFillCommand = new DrawBucketFillCommand(commandLineArguments);
        // Canvas Should be initialize with Empty Char
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            for (int j = 1; j < canvas.getWidth() + 1; j++) {
                assertEquals(Character.valueOf(' '), canvas.getArea().getElement(j, i));
            }
        }
        drawBucketFillCommand.draw(canvas);
        // After bucket fill is applied all canvas should be set with "0" color
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            for (int j = 1; j < canvas.getWidth() + 1; j++) {
                assertEquals(COLOR, canvas.getArea().getElement(j, i));
            }
        }
    }


    @Test
    public void drawShouldFillOnlyAreaInsideRectangle() {
        String[] commandLineArguments = {"17", "2", COLOR.toString()};
        DrawBucketFillCommand drawBucketFillCommand = new DrawBucketFillCommand(commandLineArguments);
        String[] rectangleCommandLineArguments = {"16", "1", "20", "3"};
        DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(rectangleCommandLineArguments);
        drawRectangleCommand.draw(canvas);
        drawBucketFillCommand.draw(canvas);
        List elements = Arrays.asList(16, 17, 18, 19, 20);
        // After bucket fill is applied all canvas should be set with "0" color
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            for (int j = 1; j < canvas.getWidth() + 1; j++) {
                if (i == 2 && (j == 17 || j == 18 || j == 19)) {
                    assertEquals(COLOR, canvas.getArea().getElement(j, i));
                } else if (((i == 1 || i == 3) && elements.contains(j)) || (i == 2 && (j == 16 || j == 20))) {
                    assertEquals(Constants.CHAR_X, canvas.getArea().getElement(j, i));
                } else {
                    assertEquals(Character.valueOf(' '), canvas.getArea().getElement(j, i));
                }
            }
        }
    }
}
