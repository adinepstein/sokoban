package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;
import model.dispalyReciever.Displayer;
import view.View;
/**
 *
 * @author Adin Epstein
 * @since 24/12/16
 * The class executes the display command
 *
 */
public class DisplayCommand extends AbstractCommands {
	private View view;
	private Model model;

	public DisplayCommand(View view,Model model) {
		this.view=view;
		this.model=model;
	}

		/**
	 * the method creates the display receiver
	 */
	@Override
	public void execute() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		view.display(model.getLevel());

	}

}
