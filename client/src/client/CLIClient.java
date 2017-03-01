package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CLIClient {

	private void readInputsAndSend(BufferedReader in,PrintWriter out,String exitStr){
		try{
			String line;
			while(!(line=in.readLine()).equals(exitStr)){
				System.out.println(line);
				out.println(line);
				out.flush();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	private Thread aSyncReadInputsAndSend(final BufferedReader in,final PrintWriter out,final String exitStr){
		Thread t=new Thread(new Runnable() {
			@Override
			public void run() { readInputsAndSend(in, out, exitStr); }
		});
		t.start();
		return t;
	}
	public void start(String ip,int port){
		try{
			Socket theServer=new Socket(ip,port);
			System.out.println("connected to server");

			BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader serverInput= new BufferedReader(new InputStreamReader(theServer.getInputStream()));

			PrintWriter outToServer=new PrintWriter(theServer.getOutputStream());
			PrintWriter outToScreen=new PrintWriter(System.out);

			Thread t1= aSyncReadInputsAndSend(userInput, outToServer, "exit");
			Thread t2= aSyncReadInputsAndSend(serverInput, outToScreen, "bye");

			t1.join();
			t2.join();

			userInput.close();
			serverInput.close();
			outToServer.close();
			outToScreen.close();
			theServer.close();
		}
		catch(IOException | InterruptedException e){e.getStackTrace();}

	}
}


