package model.data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import common.Level;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class saves an object file
 *
 */
public class MyObjectLevelSaver implements LevelSaver {
	private Level level;
	public MyObjectLevelSaver(Level level) {
		this.level=level;
	}

	@Override
	public void saveLevel(OutputStream out) throws IOException {
		ObjectOutputStream oos=new ObjectOutputStream(out);
		oos.writeObject(level);
		oos.close();

	}

}
