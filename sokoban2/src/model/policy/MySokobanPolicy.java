package model.policy;

import java.awt.Point;

import common.Level;
import model.data.Move;
import model.data.character.Floor;
import model.data.character.GameCharacters;
import model.data.character.Player;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class is in charge of the policy of the game
 *
 */
public class MySokobanPolicy extends AbstractMover {

	private Player player;
	private GameCharacters characterNext;
	private GameCharacters characterNextNext;
	private Point playerPos;
	private int xPlayer;
	private int yPlayer;
	private int xNext;
	private int yNext;
	private int xNextNext;
	private int yNextNext;
	private Move mover;
	public MySokobanPolicy(Level level) {
		super(level);
		mover=new Move(level);
	}

private void findCharNext(String choice){
	playerPos=level.getPlayerPosition();
	xPlayer=(int)playerPos.getX();
	yPlayer=(int)playerPos.getY();
	player=(Player)level.getMap().get(xPlayer).get(yPlayer);
	choice=choice.toUpperCase();
	switch(choice){
		case "UP":
			xNext=xPlayer-1;
			yNext=yPlayer;
			xNextNext=xNext-1;
			yNextNext=yNext;
			break;
		case "DOWN":
			xNext=xPlayer+1;
			yNext=yPlayer;
			xNextNext=xNext+1;
			yNextNext=yNext;
			break;
		case "LEFT":
			xNext=xPlayer;
			yNext=yPlayer-1;
			xNextNext=xNext;
			yNextNext=yNext-1;
			break;
		case "RIGHT":
			xNext=xPlayer;
			yNext=yPlayer+1;
			xNextNext=xNext;
			yNextNext=yNext+1;
			break;
		}
		characterNext=level.getMap().get(xNext).get(yNext);
		if(((xNextNext>=0)&& (xNextNext<=level.getMap().size()-1))&& ((yNextNext>=0)&&(yNextNext<=level.getMap().get(xNextNext).size()-1)))
			characterNextNext=level.getMap().get(xNextNext).get(yNextNext);
		else
			characterNextNext=new Floor();
		}
	/**
	 * The method checks if the player can move and push boxes
	 * when a move is possible it calls the move object to move the player and push boxes
	 */
	@Override
	public void moving(String choice) {
		findCharNext(choice);
		if(checkWall(characterNext)){

		}
		else if(checkFloor(characterNext)||checkTarget(characterNext)){
			mover.move(player, characterNext);
		}
		else{
			if(checkWall(characterNextNext)||checkBox(characterNextNext)){

			}
			else{
				mover.push(characterNext, characterNextNext);
				findCharNext(choice);
				mover.move(player, characterNext);
			}

		}
		findCharNext(choice);
		}

	public boolean checkWall(GameCharacters character){
		if(character.getClass().getSimpleName().equals("Wall")){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean checkBox(GameCharacters character){
		 if(character.getClass().getSimpleName().equals("Box")){
			return true;
		}
		 else{
			 return false;
		 }
	}
	public boolean checkFloor(GameCharacters character){
		 if(character.getClass().getSimpleName().equals("Floor")){
			return true;
		}
		 else{
			 return false;
		 }
	}
	public boolean checkTarget(GameCharacters character){
		 if(character.getClass().getSimpleName().equals("Target")){
			return true;
		}
		 else{
			 return false;
		 }
	}

}
