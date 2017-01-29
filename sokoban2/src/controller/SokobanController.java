package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import controller.command.Command;
import controller.command.DisplayCommand;
import controller.command.ExitCommand;
import controller.command.LoadCommand;
import controller.command.MoveCommand;
import controller.command.SaveCommand;
import controller.server.ClientHandler;
import controller.server.MyServer;
import controller.server.Server;
import model.Model;
import view.View;

public class SokobanController implements Observer, ControllerInterface {
	private Model model;
	private View view;
	private Controller controller;
	private HashMap<String, Command> commandMap;
	private Server server;

	public SokobanController(Model model,View view) {
		this.model=model;
		this.view=view;
		controller= new Controller();
		controller.start();
		initilizeCommandMap();
		}
	public SokobanController(Model model,View view,ClientHandler ch,int port) {
		this.model=model;
		this.view=view;
		controller= new Controller();
		controller.start();
		initilizeCommandMap();
		server= new MyServer(port,ch);
		server.openServer();
		}
	@Override
	public Controller getController() {
		return controller;
	}



	public void setController(Controller controller) {
		this.controller = controller;
	}



	private void initilizeCommandMap(){
		commandMap=new HashMap<String,Command>();
		commandMap.put("move", new MoveCommand(model));
		commandMap.put("display", new DisplayCommand(view,model));
		commandMap.put("load", new LoadCommand(model));
		commandMap.put("save", new SaveCommand(model));
		commandMap.put("exit", new ExitCommand(this));

	}
	@Override
	public void update(Observable arg0, Object arg1) {
		try{
		LinkedList<String> params =  (LinkedList<String>) arg1;
		String commandKey = params.removeFirst();
		Command c = commandMap.get(commandKey);

		if(!(c.getClass().getSimpleName().equals("DisplayCommand"))&&!(c.getClass().getSimpleName().equals("ExitCommand")))
				c.setParams(params);
		this.controller.insertCommand(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	public void setServer(Server server) {
		this.server = server;
	}
	@Override
	public Server getServer() {

		return server;
	}

}
