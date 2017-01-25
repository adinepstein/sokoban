package controller;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import controller.command.Command;

public class Controller {
	private BlockingQueue<Command> bq;
	private boolean stop;

	public Controller() {
	bq=new ArrayBlockingQueue<Command>(10);
	stop=false;
}

	public void start(){
		Thread thread=new Thread(new Runnable() {

			@Override
			public void run() {
				while(!stop){
				try{
					Command command= bq.take();
					if(command != null)
						command.execute();
					}catch(InterruptedException | ClassNotFoundException | IOException e){
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();

	}
	public void stop(){
		stop=true;
	}

	public void insertCommand(Command command){
		try {
			bq.put(command);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
