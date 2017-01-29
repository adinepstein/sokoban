package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.Controller;
import controller.ControllerInterface;
import model.exitReciever.Exiter;
import model.exitReciever.MyExiter;
/**
 * @author Adin Epstein
 * @since 24/12/16
 * The class executes the exit command
 *
 *
 */
public class ExitCommand extends AbstractCommands {

	private boolean exitFlag;
	private ControllerInterface controllerInterface;

public ExitCommand(ControllerInterface controllerInterface) {
	this.controllerInterface=controllerInterface;
 exitFlag=false;
}
/**
 * the method creates the exit receiver
 */
	@Override
	public void execute() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		Exiter me=new MyExiter(controllerInterface);
		me.exiting();

	}
	/**
	 *
	 * @return true if the exit command was set
	 */
	public boolean isExitFlag() {
		return exitFlag;
	}
	public void setExitFlag(boolean exitFlag) {
		this.exitFlag = exitFlag;
	}

}
