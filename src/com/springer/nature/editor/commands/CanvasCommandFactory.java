package com.springer.nature.editor.commands;

import com.springer.nature.editor.commands.CreateCanvasCommand;
import com.springer.nature.editor.commands.DrawBucketFillCommand;
import com.springer.nature.editor.commands.DrawLineCommand;
import com.springer.nature.editor.commands.DrawRectangleCommand;
import com.springer.nature.editor.commands.ICommand;
import com.springer.nature.editor.commands.QuitCanvasCommand;
import com.springer.nature.editor.constants.Constants;

import java.util.Arrays;

/**
 * CanvasCommandFactory creates an ICommand from a commandLine argument
 * Created by juanvillalba on 1/06/16.
 */
public class CanvasCommandFactory {

    public static ICommand create(String commandLine) {
        String[] commandLineElements = commandLine.split(Constants.EMPTY_SPACE_SEPARATOR);
        String command = commandLineElements[0];
        String[] commandArguments = null;
        if (!Constants.QUIT_CANVAS_COMMAND.equals(command)) {
            commandArguments = Arrays.copyOfRange(commandLineElements, 1, commandLineElements.length);
        }
        switch (command) {
            case Constants.CREATE_CANVAS_COMMAND:
                return new CreateCanvasCommand(commandArguments);
            case Constants.LINE_COMMAND:
                return new DrawLineCommand(commandArguments);
            case Constants.RECTANGLE_COMMAND:
                return new DrawRectangleCommand(commandArguments);
            case Constants.BUCKET_FILL_COMMAND:
                return new DrawBucketFillCommand(commandArguments);
            case Constants.QUIT_CANVAS_COMMAND:
                return new QuitCanvasCommand();
        }
        return null;
    }
}
