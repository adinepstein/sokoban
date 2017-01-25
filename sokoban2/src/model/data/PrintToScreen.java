package model.data;

import common.Level;

/**
 *
 * @author Adin Epstein
 * @since 23/12/2016
 * The class prints the map of the level
 *
 */
public class PrintToScreen {
	private Level level;

	public PrintToScreen(Level level) {
		this.level=level;
	}

	public void print(){
		for(int i=0;i<level.getMap().size();i++){
				for(int j=0;j<level.getMap().get(i).size();j++){
				System.out.print(level.getMap().get(i).get(j).getRepresent());
			}
			System.out.println();
		}
	}


}
