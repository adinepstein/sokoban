package model.exitReciever;
/**
 * 
 * @author Adin Epstein
 * @since 25/12/16
 * this class send to the CLI a command to exit from the game loop 
 * 
 * 
 */
public class MyExiter extends AbstractExiter {

	@Override
	public void exiting() {
		exitFlag=true;

	}

}
