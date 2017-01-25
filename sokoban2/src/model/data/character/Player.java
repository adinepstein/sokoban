package model.data.character;

public class Player extends GameCharacters {

	/**
	 * @author Adin Epstein
	 * @since 25/12/16
	 * The class represents the player character in the game.
	 * char representing is 'P'
	 */
	private static final long serialVersionUID = -8174147347943666110L;

	public Player() {
		floorFlag=true;
		targetFlag=false;
		this.setRepresent('P');
	}

public Player(int x,int y) {
	super(x,y);
	floorFlag=true;
	targetFlag=false;
	this.setRepresent('P');
}

}
