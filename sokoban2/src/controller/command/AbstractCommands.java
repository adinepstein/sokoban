package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import common.Level;
/**
 *
 * @author Adin Epstein
 * @since 24/12/16
 * Abstract class for the command execute, class that extends must implement the execute method
 *
 */
public abstract class AbstractCommands implements Command {
	protected Level level;
	protected LinkedList<String> params;

	@Override
	public void setParams(LinkedList<String> params) {
		this.params = params;
	}

	@Override
	public abstract void execute() throws FileNotFoundException, IOException, ClassNotFoundException;

}
