package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observable;

import common.Level;
import model.policy.Mover;
import model.policy.MySokobanPolicy;
import model.saveReciever.Saver;

public class MyModel extends Observable implements Model  {
	private Level level;
	private Mover mover;
	private Saver saver;



	@Override
	public Level getLevel() {
		return level;
	}



	@Override
	public void setLevel(Level level) {
		this.level=level;
		mover=new MySokobanPolicy(this.level);
		LinkedList<String> params=new LinkedList<String>();
		params.add("display");
		setChanged();
		notifyObservers(params);
	}



	@Override
	public Mover getMover() {
		return mover;
	}



	@Override
	public void setMover(Mover mover) {
		this.mover=mover;

	}



	@Override
	public void move(String direction) {
		mover.moving(direction);
		LinkedList<String> params=new LinkedList<String>();
		params.add("display");
		setChanged();
		notifyObservers(params);
	}


	@Override
	public void saving(Saver saver, String path) throws FileNotFoundException, IOException {
		this.saver=saver;
		this.saver.save(path, level);
		LinkedList<String> params=new LinkedList<String>();
		params.add("display");
		setChanged();
		notifyObservers(params);
	}





}
