package controller.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Observable;


/**
 * @author Adin Epstein
 * @since 21/01/2017
 *
 */
public class CLI extends Observable implements ClientHandler {
		private PrintWriter writer;
		private BufferedReader reader;


	@Override
	public void handleClient(InputStream inFromClient, OutputStream outToClient) {
		writer=new PrintWriter(outToClient);
		reader=new BufferedReader(new InputStreamReader(inFromClient));

		String commandLine="";
		do{
			writer.write("Please enter a command: ");
			writer.flush();
			try {
				commandLine = reader.readLine();
				String[] arr = commandLine.split(" ");
				LinkedList<String> params = new LinkedList<String>();
				for (String param : arr) {
					params.add(param);
				}
				if(!commandLine.equals("exit")){
					setChanged();
					notifyObservers(params);
					}
			 	} catch (IOException e) {

				e.printStackTrace();
			}

		}while(!commandLine.equals("exit"));
	}

}
