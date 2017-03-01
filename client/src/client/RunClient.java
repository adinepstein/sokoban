package client;

public class RunClient {

	public static void main(String[] args) {
		CLIClient cl= new CLIClient();
		cl.start("localhost", 1338);

	}

}
