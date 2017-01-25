package model.exitReciever;
/**
 * 
 * @author Adin Epstein
 * @since 25/12/16
 * Abstract class that implements the exiter interface.
 * class that extends this class must implement the exiting method
 * 
 */
public abstract class AbstractExiter implements Exiter {
	protected boolean exitFlag;
/**
 * 
 * @return true if exit flag was used
 */
	public boolean isExitFlag() {
		return exitFlag;
	}
/**
 * 
 * @param set if the exit flag is used or not
 */
	public void setExitFlag(boolean exitFlag) {
		this.exitFlag = exitFlag;
	}

	public abstract void exiting(); 
		

	

}
