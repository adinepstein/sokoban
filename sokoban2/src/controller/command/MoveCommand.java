package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;
import model.policy.Mover;
/**
* @author Adin Epstein
* @since 25/12/16
* The class executes the move command
*/
public class MoveCommand extends AbstractCommands {
	private String direction;
	private Model model;


	public MoveCommand(Model model) {
		this.model=model;
		}
	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}


	/**
	 * The method creates the move receiver
	 */
	@Override
	public void execute() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		direction=params.removeFirst();
		model.move(direction);

	}

}
