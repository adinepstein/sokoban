package model.data;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import common.Level;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class saves an XML file
 *
 */
public class MyXMLLevelSaver implements LevelSaver {
	private Level level;
	public MyXMLLevelSaver(Level level) {
		this.level=level;
	}

	@Override
	public void saveLevel(OutputStream out) throws IOException {
		XMLEncoder encoder=new XMLEncoder(new BufferedOutputStream(out));
		encoder.writeObject(level);
		encoder.close();
	}

}
