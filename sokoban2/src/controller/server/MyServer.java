package controller.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer  {
	private int port;
	private ClientHandler ch;
	private boolean stop;

	public MyServer(int port, ClientHandler ch) {
		this.port=port;
		this.ch=ch;
		stop=false;
	}
public void runServer() throws Exception {
	ServerSocket server=new ServerSocket(port);
	server.setSoTimeout(1000);
	while(!stop){
		try{
		Socket aClient=server.accept();
		ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());
		aClient.getInputStream().close();
		aClient.getOutputStream().close();
		aClient.close();
		}
		catch(SocketTimeoutException e){

		}
	}
}
public void stopServer(){
	stop=true;
}
}