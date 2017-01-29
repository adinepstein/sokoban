package view;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import common.Level;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SokobanDisplayer extends Canvas {

	private StringProperty wallFileName;
	private StringProperty characterFileName;
	private StringProperty targetFileName;
	private StringProperty boxFileName;
	private StringProperty floorFileName;
	private Level level;

	public SokobanDisplayer() {
		wallFileName=new SimpleStringProperty();
		characterFileName=new SimpleStringProperty();
		targetFileName=new SimpleStringProperty();
		boxFileName=new SimpleStringProperty();
		floorFileName=new SimpleStringProperty();

	}



	public void redraw() {
		double W=getWidth();
		double H=getHeight();
		double w=W /level.getWidth();
		double h=H /level.getHeight();

		GraphicsContext gc=getGraphicsContext2D();
		Image wall=null;
		Image character=null;
		Image floor=null;
		Image box=null;
		Image target=null;
		try {
			wall = new Image(new FileInputStream(wallFileName.get()));
			floor = new Image(new FileInputStream(floorFileName.get()));
			box = new Image(new FileInputStream(boxFileName.get()));
			character= new Image(new FileInputStream(characterFileName.get()));
			target = new Image(new FileInputStream(targetFileName.get()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		gc.clearRect(0, 0, W, H);
		for(int i=0;i<level.getHeight();i++)
			for(int j=0; j<level.getMap().get(i).size() ;j++){
					if(level.getMap().get(i).get(j).getRepresent()=='#')
						gc.drawImage(wall, j*w, i*h, w, h);
					else if(level.getMap().get(i).get(j).getRepresent()=='@')
						gc.drawImage(box, j*w, i*h, w, h);
					else if(level.getMap().get(i).get(j).getRepresent()=='o')
						gc.drawImage(target, j*w, i*h, w, h);
					else if(level.getMap().get(i).get(j).getRepresent()=='P')
						gc.drawImage(character, j*w, i*h, w, h);
					else
						gc.drawImage(floor, j*w, i*h, w, h);
			}
	}

	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
		redraw();

	}


	public String getWallFileName() {
		return wallFileName.get();
	}

	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}
	public String getCharacterFileName() {
		return characterFileName.get();
	}

	public void setCharacterFileName(String characterFileName) {
		this.characterFileName.set(characterFileName);
	}
	public String getTargetFileName() {
		return targetFileName.get();
	}

	public void setTargetFileName(String  targetFileName) {
		this.targetFileName.set( targetFileName);
	}
	public String getBoxFileName() {
		return wallFileName.get();
	}

	public void setBoxFileName(String boxFileName) {
		this.boxFileName.set(boxFileName);
	}
	public String getFloorFileName() {
		return floorFileName.get();
	}

	public void setFloorFileName(String floorFileName) {
		this.floorFileName.set(floorFileName);
	}

}
