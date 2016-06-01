package com.springer.nature.editor.canvas;

import com.springer.nature.editor.commands.CreateCanvasCommand;
import com.springer.nature.editor.commands.DrawLineCommand;
import com.springer.nature.editor.constants.Constants;
import com.springer.nature.editor.output.ConsoleOutputFormat;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class CanvasTests {

    Canvas canvas;

    @Before
    public void setUp() throws Exception {
        String[] commandLineArguments = {"20", "4"};
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(commandLineArguments);
        canvas = new Canvas(createCanvasCommand, new ConsoleOutputFormat());
    }

    @Test
    public void newCanvasShouldCreateAreaWithRightWidthAndHeightAndHasOneCommand() {
        assertNotNull(canvas.getArea());
        assertEquals(20, canvas.getWidth());
        assertEquals(4, canvas.getHeight());
        assertEquals(1, canvas.getCommands().size());
        assertEquals(Constants.CREATE_CANVAS_COMMAND, canvas.getCommands().get(0).getName());
    }

    @Test
    public void addDrawLineCommandShouldIncreaseNumberOfCommandsAndDrawALine() {
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
