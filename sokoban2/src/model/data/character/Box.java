package model.data.character;

public class Box extends GameCharacters {
	

/**
	 * @author Adin Epstein
	 * @since 25/12/16
	 * The class represents a box character in the game.
	 * char representing is '@'
	 */
	private static final long serialVersionUID = -500666338785516935L;
public Box() {
	floorFlag=true;
	targetFlag=false;
	this.setRepresent('@');
}
public Box(int x,int y) {
	super(x,y);
	floorFlag=true;
	targetFlag=false;
	this.setRepresent('@');
	
}
}
