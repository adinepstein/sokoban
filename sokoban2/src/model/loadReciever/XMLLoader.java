package model.loadReciever;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import common.Level;
import model.data.MyXMLLevelLoader;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class creates a XML loader
 *
 */
public class XMLLoader extends AbstractLoader {

	@Override
	public Level load(String file) throws FileNotFoundException, IOException {
		FileInputStream fis= new FileInputStream(file);
		MyXMLLevelLoader xmlLoader=new MyXMLLevelLoader();
		return xmlLoader.loadLevel(fis);
	}

}
