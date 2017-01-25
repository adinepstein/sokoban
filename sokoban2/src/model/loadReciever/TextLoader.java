package model.loadReciever;

import java.io.FileInputStream;
import java.io.IOException;

import common.Level;
import model.data.MyTextLevelLoader;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class creates a text loader
 *
 */
public class TextLoader extends AbstractLoader {

	@Override
	public Level load(String file) throws IOException {
		FileInputStream fos=new FileInputStream(file);
		MyTextLevelLoader txtloader=new MyTextLevelLoader();
		return txtloader.loadLevel(fos);

	}

}
