package com.kreitek.editor.commands;
import java.util.ArrayList;
import com.kreitek.editor.commands.*;
import com.kreitek.editor.*;
import com.kreitek.editor.commands.UndoCommand;
public class CommandFactory{
    private static final CommandParser commandParser = new CommandParser();
    private final ArrayList<String> documentLines;
    
    public CommandFactory(ArrayList<String> documentLines) {
        this.documentLines = documentLines;
    }



	public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand(documentLines);
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand(ArrayList<String> documentLines) {
        return new UndoCommand(documentLines);
    }
    
    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number);
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text);
    }

}
