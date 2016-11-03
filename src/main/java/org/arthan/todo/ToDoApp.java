package org.arthan.todo;

import org.arthan.todo.util.CommandLineInput;
import org.arthan.todo.util.CommandLineInputHandler;

/**
 * Created by ashamsiev on 03.11.2016
 */
public class ToDoApp {
    public static final char DEFAULT_INPUT = '\u0000';

    public static void main(String args[]) {
        CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
        char command = DEFAULT_INPUT;

        while (CommandLineInput.EXIT.getShortCmd() != command) {
            commandLineInputHandler.printOptions();
            String input = commandLineInputHandler.readInput();
            char[] inputChars = input.length() == 1 ? input.toCharArray() : new char[]{DEFAULT_INPUT};
            command = inputChars[0];
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
            commandLineInputHandler.processInput(commandLineInput);
        }
    }
}
