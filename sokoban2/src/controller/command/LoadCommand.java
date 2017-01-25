package controller.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import common.Level;
import model.Model;
import model.loadReciever.Loader;
import model.loadReciever.ObjLoader;
import model.loadReciever.TextLoader;
import model.loadReciever.XMLLoader;

/**
 *
 * @author adin epstein
 * @since 25/12/16
 * The class executes the load command using a hash map for loading the correct file
 * The class can load txt, obj and xml files
 *
 */
public class LoadCommand extends AbstractCommands {
	private HashMap<String,Loader> levelCreator;
	private String path;
	private Model model;

	public LoadCommand(Model model) {
		this.model=model;
		createLevel();
	}



	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private void createLevel(){
		levelCreator=new HashMap<String,Loader>();
		levelCreator.put("txt", new TextLoader());
		levelCreator.put("obj", new ObjLoader());
		levelCreator.put("xml", new XMLLoader());
	}

	/**
	 * the method creates the load receiver with the path of the file
	 */
	@Override
	public void execute() throws FileNotFoundException, IOException, ClassNotFoundException {
		path=params.removeFirst();
		String type=path.substring(path.lastIndexOf(".")).substring(1);
		level=levelCreator.get(type).load(path);
		model.setLevel(level);
	}
	/**
	 *
	 * @return the level after the loading
	 */
	public Level getLevel(){
		return level;
	}

}
