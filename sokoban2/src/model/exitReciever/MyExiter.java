package model.exitReciever;

import controller.Controller;
import controller.ControllerInterface;

/**
 *
 * @author Adin Epstein
 * @since 25/12/16
 * this class send to the CLI a command to exit from the game loop
 *
 *
 */
public class MyExiter extends AbstractExiter {

	private ControllerInterface controllerInterface;

public MyExiter(ControllerInterface controller) {
 this.controllerInterface=controller;
}


	@Override
	public void exiting() {

		controllerInterface.getController().stop();

		if(controllerInterface.getServer()!=null)
		 controllerInterface.getServer().stopServer();
	}

}
