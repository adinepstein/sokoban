package model.loadReciever;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.Level;

/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * Interface for loading files
 * all class's that load a file must implement the loader and implement the load method
 *
 */
public interface Loader {
	public Level load(String file) throws FileNotFoundException, IOException, ClassNotFoundException;

}
