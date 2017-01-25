package model.data.character;

import java.awt.Point;
import java.io.Serializable;

public abstract class GameCharacters implements Serializable {
	
	/**
	 *@author Adin Epstein 
	 *@since 25/12/16
	 * The class is a general abstract character in the game.
	 * @param position hold the x and y of the character on the board
	 * @param targetFlag true if the character is standing on a box target
	 * @param FloorFlag true if the character is standing on floor  
	 */
	private static final long serialVersionUID = -238716388797760488L;
	protected Point position;
	protected char represent;
	protected boolean targetFlag;
	protected boolean floorFlag;
	public GameCharacters() {
		position=new Point(0,0);
	}
	public GameCharacters(int x,int y) {
		position=new Point(x,y);
	}
	/**
	 * 
	 * @return the position of character 
	 */
	public Point getPosition() {
		return position;
	}
	/**
	 * 
	 * @param position sets a new position of the character
	 */
	public void setPosition(Point position) {
		this.position.setLocation(position.getX(), position.getY());
	}
	/**
	 * 
	 * @return the char represent of the character
	 */
	public char getRepresent() {
		return represent;
	}
	/**
	 * 
	 * @param represent set a char represent for the character 
	 */
	public void setRepresent(char represent) {
		this.represent = represent;
	}
	/**
	 * 
	 * @return true if the character is standing on a target
	 */
	public boolean isTargetFlag() {
		return targetFlag;
	}
	/**
	 * 
	 * @param t sets true or false on target standing
	 */
	public void setTargetFlag(boolean t) {
		 targetFlag=t;
		}
	/**
	 * 
	 * @return true if character is standing on floor
	 */
	public boolean isFloorFlag() {
		return floorFlag;
	}
	/**
	 * 
	 * @param t sets true or false on floor standing
	 */
	public void setFloorFlag(boolean t) {
		floorFlag=t;
		
	}
	
	
	
	
}
