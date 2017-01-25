package model.data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;

import common.Level;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class loads an XML file
 *
 */
public class MyXMLLevelLoader implements LevelLoader {
	private Level level;
	@Override
	public Level loadLevel(InputStream file) {
		XMLDecoder decoder= new XMLDecoder(new BufferedInputStream(file));
		level=(Level)decoder.readObject();
		decoder.close();
		return level;
	}

}
