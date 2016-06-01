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
public class LineTests {

    Canvas canvas = null;

    @Before
    public void setUp() {
        String[] commandLineArguments = {"20", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand, new ConsoleOutputFormat());
    }

    @Test
    public void drawShouldWriteAnHorizontalLine() {
        Line line = new Line(1, 2, 6, 2, Constants.CHAR_X);
        line.draw(canvas);
        List elements = Arrays.asList(1, 2, 3, 4, 5, 6);
        int lineLength = 0;
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            for (int j = 1; j < canvas.getWidth() + 1; j++) {
                if (i == 2 && elements.contains(j)) {
                    assertEquals(Constants.CHAR_X, canvas.getArea().getElement(j, i));
                    lineLength++;
                } else {
                    assertEquals(Character.valueOf(' '), canvas.getArea().getElement(j, i));
                }
            }
        }
        assertEquals(6, lineLength);
    }

    @Test
    public void drawShouldWriteAnVerticalLine() {
        Line line = new Line(2, 1, 2, 4, Constants.CHAR_X);
        line.draw(canvas);
        List elements = Arrays.asList(1, 2, 3, 4, 5, 6);
        int lineLength = 0;
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            for (int j = 1; j < canvas.getWidth() + 1; j++) {
                if (j == 2 && elements.contains(i)) {
                    assertEquals(Constants.CHAR_X, canvas.getArea().getElement(j, i));
                    lineLength++;
                } else {
                    assertEquals(Character.valueOf(' '), canvas.getArea().getElement(j, i));
                }
            }
        }
        assertEquals(4, lineLength);
    }
}
