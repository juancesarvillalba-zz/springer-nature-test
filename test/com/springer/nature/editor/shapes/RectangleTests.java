package com.springer.nature.editor.shapes;

import com.springer.nature.editor.canvas.Canvas;
import com.springer.nature.editor.commands.CreateCanvasCommand;
import com.springer.nature.editor.constants.Constants;
import com.springer.nature.editor.output.ConsoleOutputFormat;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class RectangleTests {

    Canvas canvas = null;

    @Before
    public void setUp() {
        String[] commandLineArguments = {"20", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand, new ConsoleOutputFormat());
    }

    @Test
    public void drawShouldWriteARectangle() {
        Rectangle rectangle = new Rectangle(16, 1, 20, 3);
        rectangle.draw(canvas);
        List elements = Arrays.asList(16, 17, 18, 19, 20);
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            for (int j = 1; j < canvas.getWidth() + 1; j++) {
                if (((i == 1 || i == 3) && elements.contains(j)) || (i == 2 && (j == 16 || j == 20))) {
                    assertEquals(Constants.CHAR_X, canvas.getArea().getElement(j, i));
                } else {
                    assertEquals(Character.valueOf(' '), canvas.getArea().getElement(j, i));
                }
            }
        }
    }
}
