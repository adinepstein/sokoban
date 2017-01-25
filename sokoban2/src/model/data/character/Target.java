package model.data.character;

public class Target extends GameCharacters {

	/**
	 * @author Adin Epstein
	 * @since 25/12/16
	 * The class represents a box target character in the game.
	 * char representing is 'o'
	 */
	private static final long serialVersionUID = 6134228686513385404L;

	public Target() {
		floorFlag=false;
		targetFlag=true;
		this.setRepresent('o');
	}

public Target(int x,int y) {
	super(x,y);
	floorFlag=false;
	targetFlag=true;
	this.setRepresent('o');
}

}
