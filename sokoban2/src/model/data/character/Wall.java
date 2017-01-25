package model.data.character;

public class Wall extends GameCharacters {

	/**
 	 * @author Adin Epstein
	 * @since 25/12/16
	 * The class represents a box character in the game.
	 * char representing is '#'
	 * 
	 */
	private static final long serialVersionUID = -5087777711798148927L;

public Wall() {
	floorFlag=false;
	targetFlag=false;
	this.setRepresent('#');
}

public Wall(int x,int y) {
	super(x,y);
	floorFlag=false;
	targetFlag=false;
	this.setRepresent('#');
}


}
