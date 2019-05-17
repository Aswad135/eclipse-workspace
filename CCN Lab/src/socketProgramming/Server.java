/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketProgramming;

/**
 *
 * 
 */

import java.io.*;
import java.net.*;

public class Server
{
	private Socket		socket = null; 
	private ServerSocket server = null; 
	private DataInputStream x	 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 
 
	public Server(int port) 
	
        {   
            try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 
                        System.out.println("Waiting for a client ..."); 
                        socket = server.accept(); 
			System.out.println("Client accepted"); 
                	x = new DataInputStream( new BufferedInputStream(socket.getInputStream())); 
                        input = new DataInputStream(System.in); 
                        out = new DataOutputStream(socket.getOutputStream()); 
        
			String client = ""; 
                        String server = "";
                	while (!client.equals("Bye")) 
			{ 
				try
				{       
                                        
					client = x.readUTF(); 
					System.out.println("Recieved from Client: "+client); 
                                        server = input.readLine(); 
                                        out.writeUTF(server); 

				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			x.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 
    public static void main(String[] args)
    {
        Server server = new Server(6969); 
    }
}
