package model.data;

import java.io.IOException;
import java.io.InputStream;

import common.Level;

/**
 * @author Adin Epstein
 * @since 21/12/2016
 *  The Level data is saved in the level class while the levelLoader is an interface that allows to load all kind of files by implementing LevelLoader.
 * If you want to load a new type of file The separation allows to add a new class that implements LevelLoader with out changing other class.
 * It keeps the Liskov Substitution Principle because you can add and remove type of files with out changing the code, for example if we don't want to allow to load a XML file we just remove MyXMLLevelLoader class.
 * InputStream is the highest in the uploading hierarchy. so every type of uploading must inherit the InputStream class and we won't have to change the code.
 */
public interface LevelLoader {
	public Level loadLevel(InputStream file) throws IOException, ClassNotFoundException;

}
