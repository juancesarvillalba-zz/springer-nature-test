package com.springer.nature.editor.canvas;

import com.springer.nature.editor.commands.CreateCanvasCommand;
import com.springer.nature.editor.commands.ICommand;
import com.springer.nature.editor.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class Canvas implements ICanvas {

    private Area area;

    private List<ICommand> commands = new ArrayList<ICommand>();

    public Canvas(CreateCanvasCommand createCommand) {
        this.area = new Area(createCommand.getWidth(), createCommand.getHeight());
        addCommand(createCommand);
    }

    public boolean addCommand(ICommand command) {
        if (command != null) {
            getCommands().add(command);
            if (!Constants.QUIT_CANVAS_COMMAND.equals(command.getName())) {
                render();
            }
            return true;
        }
        return false;
    }

    public List<ICommand> getCommands() {
        return commands;
    }

    @Override
    public void render() {
        drawCanvas();
        displayCanvas();
    }

    private void displayCanvas() {
        displayHorizontalBorder();
        for (int i = 1; i < area.getHeight() + 1; i++) {
            printChar(Constants.CHAR_PIPE);
            for (int j = 1; j < area.getWidth() + 1; j++) {
                printChar(area.getElement(j, i));
            }
            printChar('|');
            printNewLine();
        }
        displayHorizontalBorder();
    }

    private void drawCanvas() {
        for (ICommand command : commands) {
            command.draw(this);
        }
    }

    private void displayHorizontalBorder() {
        for (int i = 0; i < area.getWidth() + 2; i++) {
            printChar(Constants.CHAR_DASH);
        }
        printNewLine();
    }

    private void printChar(Character character) {
        System.out.print(character);
    }

    private void printNewLine() {
        System.out.println("");
    }

    @Override
    public void setElement(int x, int y, char c) {
        area.setElement(x, y, c);
    }


    @Override
    public Character getElement(int x, int y) {
        return area.getElement(x, y);
    }

    @Override
    public Area getArea() {
        return area;
    }

    @Override
    public int getWidth() {
        return area.getWidth();
    }

    @Override
    public int getHeight() {
        return area.getHeight();
    }
}
