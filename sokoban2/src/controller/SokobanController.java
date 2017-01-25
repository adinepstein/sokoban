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
import controller.server.MyServer;
import model.Model;
import view.View;

public class SokobanController implements Observer {
	private Model model;
	private View view;
	private Controller controller;
	private HashMap<String, Command> commandMap;
	private MyServer myServer;
	private boolean stopServer;

	public SokobanController(Model model,View view) {
		this.model=model;
		this.view=view;
		controller= new Controller();
		controller.start();
		initilizeCommandMap();
		stopServer=false;
	}

	public Controller getController() {
		return controller;
	}

	public boolean isStopServer() {
		return stopServer;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setStopServer(boolean stopServer) {
		this.stopServer = stopServer;
	}

	private void initilizeCommandMap(){
		commandMap=new HashMap<String,Command>();
		commandMap.put("move", new MoveCommand(model));
		commandMap.put("display", new DisplayCommand(view,model));
		commandMap.put("load", new LoadCommand(model));
		commandMap.put("save", new SaveCommand(model));
		commandMap.put("exit", new ExitCommand());

	}
	@Override
	public void update(Observable arg0, Object arg1) {
		try{
		LinkedList<String> params =  (LinkedList<String>) arg1;
		String commandKey = params.removeFirst();
		Command c = commandMap.get(commandKey);

		if(!(c.getClass().getSimpleName().equals("DisplayCommand")))
				c.setParams(params);
		this.controller.insertCommand(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void openServer(){
		Thread t= new Thread(new Runnable(){
			@Override
			public void run() {
				while(!stopServer){
					try {
						myServer.runServer();
					} catch (Exception e) {
						//check were to send the message
						e.printStackTrace();
					}
				}

			}
		});
		t.start();
	}
	public void stopServer(){
		stopServer=true;
	}

	public void setMyServer(MyServer myServer) {
		this.myServer = myServer;
	}

}
