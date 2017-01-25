package model.exitReciever;

import controller.Controller;

/**
 *
 * @author Adin Epstein
 * @since 25/12/16
 * this class send to the CLI a command to exit from the game loop
 *
 *
 */
public class MyExiter extends AbstractExiter {

	private Controller controller;

public MyExiter(Controller controller) {
 this.controller=controller;
}


	@Override
	public void exiting() {

		controller.stop();

	}

}
