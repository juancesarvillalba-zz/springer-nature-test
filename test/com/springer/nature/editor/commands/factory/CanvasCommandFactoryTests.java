package com.springer.nature.editor.commands.factory;

import com.springer.nature.editor.commands.CanvasCommandFactory;
import com.springer.nature.editor.commands.ICommand;
import com.springer.nature.editor.constants.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class CanvasCommandFactoryTests {

    @Test
    public void createShouldCreateLineCommand() {
        String commandLine = "L 1 2 6 2";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertEquals(Constants.LINE_COMMAND, command.getName());
    }

    @Test
    public void createShouldCreateRectangleCommand() {
        String commandLine = "R 1 2 6 2";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertEquals(Constants.RECTANGLE_COMMAND, command.getName());
    }

    @Test
    public void createShouldCreateBucketFillCommand() {
        String commandLine = "B 10 3 o";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertEquals(Constants.BUCKET_FILL_COMMAND, command.getName());
    }

    @Test
    public void createShouldCreateQuitCanvasCommand() {
        String commandLine = "Q";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertEquals(Constants.QUIT_CANVAS_COMMAND, command.getName());
    }

    @Test
    public void createShouldCreateCreateCanvasCommand() {
        String commandLine = "C 20 4";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertEquals(Constants.CREATE_CANVAS_COMMAND, command.getName());
    }

    @Test
    public void createShouldReturnNullWhenInexistentCommand() {
        String commandLine = "XXX 20 4";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertNull(command);
    }

    @Test(expected = Exception.class)
    public void createShouldThrowsExceptionWhenWrongArgumentsArePassed() {
        String commandLine = "L 1 2 X 2";
        ICommand command = CanvasCommandFactory.create(commandLine);
        assertEquals(Constants.LINE_COMMAND, command.getName());
    }
}
