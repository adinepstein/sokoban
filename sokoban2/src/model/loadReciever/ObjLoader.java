package model.loadReciever;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import common.Level;
import model.data.MyObjectLevelLoader;

/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class creates a object loader
 *
 */
public class ObjLoader extends AbstractLoader {

	@Override
	public Level load(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(file);
		MyObjectLevelLoader objLoader=new MyObjectLevelLoader();
		 return objLoader.loadLevel(fis);
	}

}
