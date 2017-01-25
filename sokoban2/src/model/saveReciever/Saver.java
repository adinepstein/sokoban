package model.saveReciever;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.Level;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * Interface for saving levels
 * all class's that save a file must implement the saver and implement the save method
 *
 */
public interface Saver {
	public void save(String file,Level level) throws FileNotFoundException, IOException;

}
