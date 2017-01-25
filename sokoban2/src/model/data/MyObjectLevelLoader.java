package model.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import common.Level;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class loads an object file
 *
 */
public class MyObjectLevelLoader implements LevelLoader {
	Level level;
	@Override
	public Level loadLevel(InputStream file) throws IOException, ClassNotFoundException {
		ObjectInputStream ois=new ObjectInputStream(file);
		level=((Level)ois.readObject());
		ois.close();
		return level;

	}


}
