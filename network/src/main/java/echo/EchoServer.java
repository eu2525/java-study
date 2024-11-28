package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 60000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts...[port:"+ PORT + "]");
			
			// accept가 1번 하고 나서 종료되므로 1번의 연결밖에 하지 못함 
			// while True문 안에 넣어서 계속 accept이 되도록 해야 서버의 역할을 할 수 있음.
			while(true) {
				Socket socket = serverSocket.accept(); 
				new EchoRequestHandler(socket).start();
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
		System.out.println("[Echo Server] " + message);
	}

}
