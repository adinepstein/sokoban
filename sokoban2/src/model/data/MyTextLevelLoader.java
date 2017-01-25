package model.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.Level;
import model.data.character.Box;
import model.data.character.Floor;
import model.data.character.GameCharacters;
import model.data.character.Player;
import model.data.character.Target;
import model.data.character.Wall;
/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class loads a text file
 *
 */
public class MyTextLevelLoader implements LevelLoader {
	Level level;

	public MyTextLevelLoader() {
		level=new Level();
	}

	@Override
	public Level loadLevel(InputStream file) throws IOException {
		InputStreamReader isr= new InputStreamReader(file);
		BufferedReader bufferedReader=new BufferedReader(isr);
		String line;
		char c;
		int i=-1;
		while((line=bufferedReader.readLine()) !=null){
			level.getMap().add(new ArrayList<GameCharacters>());
			i++;
			for(int j=0;j < line.length();j++){
				c=line.charAt(j);
				switch(c){
				case '#':
					level.getMap().get(i).add(new Wall());
					level.getMap().get(i).get(j).getPosition().setLocation(i, j);
					break;
				case '@':
					level.getMap().get(i).add(new Box());
					level.getMap().get(i).get(j).getPosition().setLocation(i, j);
					break;
				case ' ':
					level.getMap().get(i).add(new Floor());
					level.getMap().get(i).get(j).getPosition().setLocation(i, j);
					break;
				case 'o':
					level.getMap().get(i).add(new Target());
					level.getMap().get(i).get(j).getPosition().setLocation(i, j);
					level.addTarget();
					break;
				case 'A':
					level.getMap().get(i).add(new Player());
					level.getMap().get(i).get(j).getPosition().setLocation(i, j);
					level.getStartPoint().setLocation(i,j);
					level.getPlayerPosition().setLocation(i,j);
					break;
				}

			}
			if(level.getMap().get(i).size()>level.getWidth())
				level.setWidth(level.getMap().get(i).size());
		}
		level.setHeight(level.getMap().size());
		isr.close();
		bufferedReader.close();

		return level;
	}
		}


