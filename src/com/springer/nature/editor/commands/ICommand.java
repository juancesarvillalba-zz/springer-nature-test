package com.springer.nature.editor.commands;

import com.springer.nature.editor.canvas.ICanvas;

/**
 * Created by juanvillalba on 1/06/16.
 */
public interface ICommand {

    String getName();

    void draw(ICanvas canvas);
}
