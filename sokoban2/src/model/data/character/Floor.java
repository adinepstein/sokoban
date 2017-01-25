package model.data.character;

public class Floor extends GameCharacters {

	/**
	 * @author Adin Epstein 
	 * @since 25/12/16
	 * The class represents a floor character in the game.
	 * char representing is ' '
	 */
	private static final long serialVersionUID = 8571461702243583988L;

	public Floor() {
		floorFlag=true;
		targetFlag=false;
		this.setRepresent(' ');
	}

public Floor(int x,int y) {
	super(x,y);
	floorFlag=true;
	targetFlag=false;
	this.setRepresent(' ');
}

}
