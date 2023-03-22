/*
 * File: tcpSendStringServer.java
 * server receives a string from a connected client and then sends one back to client
 */

import java.io.*;
import java.net.*;

public class tcpSendStringServer {
	private static ServerSocket listener;	// listening socket for incoming connection request
	private static Socket connSocket;		// connect socket for data transfer

	private static String reverseString(String x) {
		char s[] = x.toCharArray();
		char tmp;
		for(int i = 0, j = s.length - 1; i < j; i++, j--) {
			tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
		}

		return new String(s);
	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: PORT number (an integer, 5-digit recommended) should be specified");
			return;
		}

		try {
			// server builds the listening socket
			listener = new ServerSocket(Integer.parseInt(args[0]));
			System.out.println("Server is ready...");

			// server is waiting for incoming request
			connSocket = listener.accept();

			System.out.println("Received a client connected from " + connSocket.getRemoteSocketAddress().toString());

			// associate Java BufferedReader with the connect socket's input stream
			// prepares to receive a string from client
			BufferedReader SOCKETinput = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

			String clientString = SOCKETinput.readLine();
			System.out.println("client says: " + clientString);

			// associate Java BufferedWriter with the connect sockets's output stream
			// prepares to send a string to client
			BufferedWriter SOCKEToutput = new BufferedWriter(new OutputStreamWriter(connSocket.getOutputStream()));
			String reply = reverseString(clientString);
			SOCKEToutput.write(reply, 0, reply.length());
			SOCKEToutput.newLine();
			SOCKEToutput.flush();

			// receive another string from client and print it output
			BufferedReader SOCKETinput2 = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

			String clientString2 = SOCKETinput2.readLine();
			System.out.println("client says: " + clientString2);

			// reverse string and send back to clientString
			BufferedWriter SOCKEToutput2 = new BufferedWriter(new OutputStreamWriter(connSocket.getOutputStream()));
			String reply2 = reverseString(clientString2);
			SOCKEToutput2.write(reply2, 0, reply2.length());
			SOCKEToutput2.newLine();
			SOCKEToutput2.flush();

			// close streams and socket
			SOCKETinput.close();
			SOCKEToutput.close();
			connSocket.close();
			listener.close();
		}
		catch(IOException ioe) {
			System.out.println("[SERVER] IOException: " + ioe);
		}
	}
}
