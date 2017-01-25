package model.dispalyReciever;

import common.Level;

/**
 *
 * @author Adin Epstein
 * @since 25/12/2016
 * Interface for the display receiver, all class's that implement this interface must implement the displaying and getLevel method
 *
 */
public interface Displayer {
	public void displaying();
	public Level getLevel();

}
