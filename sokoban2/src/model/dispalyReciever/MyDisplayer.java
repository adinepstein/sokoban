package model.dispalyReciever;

import common.Level;
import model.data.PrintToScreen;

/**
 *
 * @author Adin Epstein
 * @since 25/12/2016
 * This class extends AbstractDisplayer
 * creates an object that prints to the screen
 *
 */
public class MyDisplayer extends AbstractDisplayer {

	public MyDisplayer(Level level) {
		super(level);
		}
/**
 * creates an object that prints to the screen
 */
	@Override
	public void displaying() {
		PrintToScreen display=new PrintToScreen(level);
		display.print();
	}
@Override
public Level getLevel() {
	return level;
}

}
