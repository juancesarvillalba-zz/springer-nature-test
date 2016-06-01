package com.springer.nature.editor.console;

import com.springer.nature.editor.canvas.Canvas;
import com.springer.nature.editor.canvas.ICanvas;
import com.springer.nature.editor.commands.CreateCanvasCommand;
import com.springer.nature.editor.commands.ICommand;
import com.springer.nature.editor.commands.CanvasCommandFactory;
import com.springer.nature.editor.constants.Constants;
import com.springer.nature.editor.output.ConsoleOutputFormat;

import java.util.Scanner;

/**
 * CommandLineConsoleCanvas handle the reading of command lines in the console.
 * Waits until command "C" is entered and then keep listening for commands until the command "Q" is entered.
 * Created by juanvillalba on 1/06/16.
 */
public class CommandLineConsoleCanvas {


    public void run() {
        String commandLine;
        Scanner scanIn = new Scanner(System.in);
        // Loop until user type  CREATE_CANVAS_COMMAND
        ICommand createCommand = readUntilCreateCommand(scanIn);
        ICanvas canvas = new Canvas((CreateCanvasCommand) createCommand , new ConsoleOutputFormat());
        // Start reading for drawing commands until quit command
        do {
            ICommand command = null;
            System.out.print(Constants.ENTER_COMMAND);
            commandLine = scanIn.nextLine();
            try {
                command = CanvasCommandFactory.create(commandLine);
                if (!"".equals(commandLine) && !canvas.addCommand(command)) {
                    System.out.println(Constants.WRONG_COMMAND);
                }
            } catch (Exception exception) {
                System.out.println(Constants.SOMETHING_WAS_WRONG_WITH_YOUR_LAST_COMMAND);
            }
        } while (
            !Constants.QUIT_CANVAS_COMMAND.equals(commandLine)
            );
        scanIn.close();
    }


    private ICommand readUntilCreateCommand(Scanner scanIn) {
        ICommand command = null;
        String commandLine;
        while (command == null || !Constants.CREATE_CANVAS_COMMAND.equals(command.getName())) {
            System.out.print(Constants.ENTER_COMMAND);
            commandLine = scanIn.nextLine();
            command = CanvasCommandFactory.create(commandLine);
        }
        return command;
    }
}
