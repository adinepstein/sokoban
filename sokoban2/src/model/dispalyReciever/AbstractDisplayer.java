package model.dispalyReciever;

import common.Level;

/**
 *
 * @author Adin Epstein
 * @since 25/12/16
 * Abstract class that implements the display interface.
 * class that extends this class must implement the display method
 *
 */

public abstract class AbstractDisplayer implements Displayer {
	protected Level level;
	public AbstractDisplayer(Level level) {
		this.level=level;
	}

}

