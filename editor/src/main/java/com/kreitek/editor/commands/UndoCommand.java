package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import java.util.ArrayList;

public class UndoCommand implements Command{
	private ArrayList<String> lastCommand;
	public UndoCommand(ArrayList<String> lastCommand) {
		this.lastCommand = new ArrayList<>(lastCommand);
	}
	
	public void execute(ArrayList<String> documentLines) {
		//native functions of ArrayList
		documentLines.clear();
		documentLines.addAll(lastCommand);
	}
}
