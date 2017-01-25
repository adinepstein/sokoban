package model.saveReciever;

import java.io.FileOutputStream;
import java.io.IOException;

import common.Level;
import model.data.MyXMLLevelSaver;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class creates a  object saver of XML file
 *
 */
public class XMLSaver implements Saver {

	@Override
	public void save(String file,Level level) throws IOException {
		FileOutputStream fos=new FileOutputStream(file);
		MyXMLLevelSaver xmlSaver=new MyXMLLevelSaver(level);
		xmlSaver.saveLevel(fos);
	}

}
