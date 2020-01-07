import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {

	public int PORT;
	Socket socket;
	public String ques;
	public String correct;
	public int ClientsConnected;
	public int MAXClients;
	BufferedReader reader;
	String message;

	public Server() {
		PORT = 7580;
		MAXClients = 5;
	}

	public void runServer() {
		ServerSocket serversocket;
		try {
			serversocket = new ServerSocket(PORT);
			socket = serversocket.accept();
			ClientsConnected++;
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {	
						run();
//				}
//			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getServerInfo() {
		// Get Server IP address:
		InetAddress ServerIP;
		try {
			// ServerIP = 127.0.0.1;
			ServerIP = InetAddress.getLocalHost();
			return "IP address: " + ServerIP.getHostAddress() + "";
		} catch (UnknownHostException ex) {
			return ex.getMessage();
		}
	}

	public void setQuestion(String question) {
		ques = question;

	}

	public void setCorrect(String cor) {
		this.correct = cor;
	}

	
	
	public void run() {

		message = null;

		// Send question to Clients
		try {
			PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
			printwriter.println(ques);
			printwriter.flush();
			// To get option from Client
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			message = bufferedreader.readLine();
			while (!message.isEmpty()) {
				// console output of option selescted by Client
				System.out.println("Incoming Client Message: " + message);
				message = bufferedreader.readLine();
				System.out.println(message);
				
				String name = bufferedreader.readLine();

				if (message.charAt(0) == correct.charAt(0)) {
					printwriter.println("Your answer is correct!! " +message+ correct+"\n" + name);
				} else
					printwriter.println("Your answer is wrong!! " +message+ correct+"\n"+name);
				break;
			}

			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
