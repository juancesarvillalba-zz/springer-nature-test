package com.springer.nature.editor.output;

/**
 * ConsoleOutputFormat do output operations in the console.
 * Created by juanvillalba on 1/06/16.
 */
public class ConsoleOutputFormat implements IOutputFormat {

    @Override
    public void print(Character character) {
        System.out.print(character);
    }

    @Override
    public void println() {
        System.out.println();
    }
}
