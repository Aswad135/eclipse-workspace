package socketProgramming;

public class myApp {

	public static void main(String[] args) {
		Server myServer = new Server(6969);
		Client myClient1 = new Client("172.0.0.1", 6969);
		Client myCLient2 = new Client("172.0.0.2", 6969);
		
		
		
	}
	
	
}
