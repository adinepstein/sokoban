package model.policy;

import common.Level;

/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class implements the mover interface
 * The abstract class hold a level
 *
 */
public abstract class AbstractMover implements Mover {
	protected Level level;
	public AbstractMover(Level level) {
		this.level=level;
	}

	@Override
	public abstract void moving(String choice);

}
