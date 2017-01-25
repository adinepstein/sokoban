package model.data;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author Adin Epstein
 * @since 21/12/2016
 * inerface for saving levels
 * class must implement the saveLevel method
 *
 */
public interface LevelSaver {
 public void saveLevel(OutputStream out) throws IOException;
}
