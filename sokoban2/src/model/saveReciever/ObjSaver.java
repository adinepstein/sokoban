package model.saveReciever;

import java.io.FileOutputStream;
import java.io.IOException;

import common.Level;
import model.data.MyObjectLevelSaver;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class creates a on object saver
 *
 */
public class ObjSaver implements Saver {

	@Override
	public void save(String file,Level level) throws IOException {
		FileOutputStream fos=new FileOutputStream(file);
		MyObjectLevelSaver objSaver=new MyObjectLevelSaver(level);
		objSaver.saveLevel(fos);
	}

}
