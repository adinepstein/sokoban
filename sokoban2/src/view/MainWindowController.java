package view;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.Observable;
import java.util.ResourceBundle;

import common.Level;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainWindowController extends Observable implements View,Initializable{

	@FXML
	SokobanDisplayer sd;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
sd.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->sd.requestFocus());

		sd.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				LinkedList<String> params= new LinkedList<String>();
				params.clear();
				if(event.getCode()==KeyCode.UP){
					params.add("move");
					params.add("up");
					setChanged();
					notifyObservers(params);
				}
				else if(event.getCode()==KeyCode.DOWN){
					params.add("move");
					params.add("down");
					setChanged();
					notifyObservers(params);
				}

				else if(event.getCode()==KeyCode.RIGHT){
					params.add("move");
					params.add("right");
					setChanged();
					notifyObservers(params);
				}
				else if(event.getCode()==KeyCode.LEFT){
					params.add("move");
					params.add("left");
					setChanged();
					notifyObservers(params);
				}

				}
		});

	}

	public void openFile(){
		FileChooser fc=new FileChooser();
		fc.setTitle("open file");
		fc.setInitialDirectory(new File("./resources/levels"));
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Text Files","*txt"),
				new ExtensionFilter("Object Files","*obj"),
				new ExtensionFilter("XML Files","*xml")
				);
		File chosenFile=fc.showOpenDialog(null);
		if(chosenFile!=null){
			LinkedList<String> params= new LinkedList<String>();
			params.add("load");
			params.add(chosenFile.getAbsolutePath());
			setChanged();
			notifyObservers(params);
		}

		}
	public void saveFile(){
		FileChooser fc=new FileChooser();
		fc.setTitle("save file");
		fc.setInitialDirectory(new File("./resources/levels"));
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Object Files","*obj"),
				new ExtensionFilter("XML Files","*xml")
				);
		File chosenFile=fc.showSaveDialog(null);
		if(chosenFile!=null){
			LinkedList<String> params= new LinkedList<String>();
			params.add("save");
			params.add(chosenFile.getAbsolutePath());
			setChanged();
			notifyObservers(params);
		}
		}
	public void exit(){
		Platform.exit();
		LinkedList<String> params= new LinkedList<String>();
		params.add("exit");
		setChanged();
		notifyObservers(params);

	}

	@Override
	public void display(Level level) {
		sd.setLevel(level);

	}



}
