package model.loadReciever;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.Level;

public abstract class  AbstractLoader implements Loader {

	@Override
	public abstract Level load(String file) throws FileNotFoundException, IOException, ClassNotFoundException;


}
