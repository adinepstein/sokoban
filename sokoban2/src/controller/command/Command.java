package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Adin epstein
 * @since 24/12/2016
 * Interface for all commands in the game
 *
 */
public interface Command {

	public void execute() throws FileNotFoundException, IOException, ClassNotFoundException;
	public void setParams(LinkedList<String> params);
}
