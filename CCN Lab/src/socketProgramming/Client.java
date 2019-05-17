package socketProgramming;

import java.io.*;
import java.net.*;

public class Client 
{ 
	private Socket socket		 = null; 
	private DataInputStream in	 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 
 
	public Client(String address, int port) 
	{  
		try
		{ 
			socket = new Socket(address, port);
			System.out.println("Connected"); 
			in = new DataInputStream( 
					new BufferedInputStream(socket.getInputStream())); 

			// takes input from terminal 
			input = new DataInputStream(System.in); 

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 
		String incommingString="";
		// keep reading until "Bye" is input 
		while (!line.equals("Bye")) 
		{ 
			try
			{ 
				line = input.readLine(); 
				out.writeUTF(line); 
				incommingString = in.readUTF();

				System.out.println("We Recieved from Sever :"+incommingString);
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 

		// close the connection 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String[] args)
	{
		Client myClient = new Client("127.0.0.1", 6969); 
	}

}

