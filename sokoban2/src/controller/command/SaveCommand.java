package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import common.Level;
import model.Model;
import model.saveReciever.ObjSaver;
import model.saveReciever.Saver;
import model.saveReciever.XMLSaver;

/**
 *
 * @author adin epstein
 * @since 25/12/16
 * The class executes the save command using a hash map for saving the correct file
 * The class can save obj and xml files
 *
 */
public class SaveCommand extends AbstractCommands {
	private HashMap<String,Saver> saveCreator;
	private String path;
	private Model model;
	private Saver saver;
	public SaveCommand(Model model) {
		this.model=model;
		saveLevel();
	}

	private void saveLevel(){
		saveCreator=new HashMap<String,Saver>();
		saveCreator.put("obj", new ObjSaver());
		saveCreator.put("xml", new XMLSaver());
	}
	/**
	 * the method creates the save receiver with the path of the file
	 */

	@Override
	public void execute() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		path=params.removeFirst();
		String type=path.substring(path.lastIndexOf(".")).substring(1);
		saver=saveCreator.get(type);
		model.saving(saver, path);

	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
