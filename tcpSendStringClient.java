/*
 * File: tcpSendStringClient.java
 * client connects to a public server, sends a string to server and receives a string from server
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class tcpSendStringClient {
	private static Socket connSocket;	// connect socket for data transfer

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage: Server Address and PORT number should be specified");
			System.out.println("Note: Specify Server Address first, then PORT number");
			return;
		}
		try {
			// connect to the server
			connSocket = new Socket(args[0], Integer.parseInt(args[1]));

			// associate Java BufferedWriter with the connect sockets's output stream
			// prepares to send a string to server
			// also associate Java BufferedReader with connect socket's input stream
			// prepares to receive a string from server
			BufferedWriter SOCKEToutput = new BufferedWriter(new OutputStreamWriter(connSocket.getOutputStream()));
			BufferedReader SOCKETinput = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

			// client reads a string from user input, then sends it out to server
			Scanner KEYBOARDinput = new Scanner(System.in);
			System.out.print("Please input a line: ");
			String x = KEYBOARDinput.nextLine();
			SOCKEToutput.write(x, 0, x.length());
			SOCKEToutput.newLine();
			SOCKEToutput.flush();

			// then client waits to receive server's string
			String fromServer = SOCKETinput.readLine();
			System.out.println("server says: " + fromServer);

			// then client sends string back to Server
			SOCKEToutput.write(fromServer, 0, fromServer.length());
			SOCKEToutput.newLine();
			SOCKEToutput.flush();

			// NEW then client receives new string and prints
			String fromServer2 = SOCKETinput.readLine();
			System.out.println("server says: " + fromServer2);

			// close streams and socket
			SOCKETinput.close();
			SOCKEToutput.close();
			connSocket.close();
			KEYBOARDinput.close();
		}
		catch(IOException ioe) {
			System.out.println("[CLIENT] IOException: " + ioe);
		}
	}
}
