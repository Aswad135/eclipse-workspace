import java.net.InetAddress;
import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
	String name;
	InetAddress ServersIP;
	String ServerIP = "127.0.0.1";
	int PORT;
	Socket socket;
	String readerInput = "";
	PrintWriter sendToServer ;
	BufferedReader inputFromServer;

	public Client()  {
		name = "Student";
		
		try {
			ServersIP = InetAddress.getLocalHost();
			ServerIP = ServersIP.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PORT = 7580;

	}

	public void connect() throws Exception {
		socket = new Socket(ServerIP, PORT);
		sendToServer = new PrintWriter(socket.getOutputStream(), true);
	}

	public String getQuestions() throws Exception {
		inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		return inputFromServer.readLine();
	}

	public void sendName(String name) {

		sendToServer.println(name);
	}

	public void sendAnswer(int choice){

		switch(choice) {
		case 1:
			sendToServer.println("A");
			break;
		case 2:
			sendToServer.println("B");
			break;
		case 3:
			sendToServer.println("C");
			break;
		}
		
	}

	public String getReply() throws IOException{
		return inputFromServer.readLine();
	}

}

