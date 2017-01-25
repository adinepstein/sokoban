package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.Level;
import model.policy.Mover;
import model.saveReciever.Saver;

public interface Model {
	public Level getLevel();
	public void setLevel(Level level);
	public Mover getMover();
	public void setMover(Mover mover);
	public void move(String direction);
	public void saving(Saver saver,String path) throws FileNotFoundException, IOException;

}
