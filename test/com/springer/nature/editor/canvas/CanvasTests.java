package com.springer.nature.editor.canvas;

import com.springer.nature.editor.commands.CreateCanvasCommand;
import com.springer.nature.editor.commands.DrawLineCommand;
import com.springer.nature.editor.constants.Constants;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class CanvasTests {

    Canvas canvas;

    @Test
    public void newCanvasShouldCreateAreaWithRightWidthAndHeightAndHasOneCommand() {
        String[] commandLineArguments = {"2", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand);
        assertNotNull(canvas.getArea());
        assertEquals(2, canvas.getWidth());
        assertEquals(4, canvas.getHeight());
        assertEquals(1, canvas.getCommands().size());
        assertEquals(Constants.CREATE_CANVAS_COMMAND, canvas.getCommands().get(0).getName());
    }

    @Test
    public void render() {
        String[] commandLineArguments = {"2", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        canvas.render();
        final String standardOutput = myOut.toString();
        assertEquals(1, canvas.getCommands().size());
    }

    @Test
    public void addDrawLineCommandShouldIncreaseNumberOfCommandsAndDrawALine() {
        String[] commandLineArguments = {"20", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand);
        String[] commandLineArgumentsDrawLineCommand = {"1", "2", "6", "2"};
        DrawLineCommand drawLineCommand = new DrawLineCommand(commandLineArgumentsDrawLineCommand);
        canvas.addCommand(drawLineCommand);
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
}
