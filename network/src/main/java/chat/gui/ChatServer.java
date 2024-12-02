package chat.gui;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 7654;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = null;
		try {
			listWriters = new ArrayList<Writer>();
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts...[port:"+ PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept(); 
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed() ) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}	
	}
	
	public static void log(String message) {
		System.out.println("[Chat Server] " + message);
	}

}
