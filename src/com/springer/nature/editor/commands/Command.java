package com.springer.nature.editor.commands;

import com.springer.nature.editor.canvas.ICanvas;

/**
 * Created by juanvillalba on 1/06/16.
 */
public class Command implements ICommand {

    private String name;

    public Command(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void draw(ICanvas canvas) {
    }
}
