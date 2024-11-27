package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1.소켓 객체 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(Binding)
			// 		    여기에 넣는 IP는 어떤 ip가 Connect를 할 수 있는지를 적는거임
			// 		    Socket에 InetSocketAddress[InetAddress(IPAddress) + port]를 바인딩한다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));

			// 3. accept
			Socket socket = serverSocket.accept(); // blocking  -> Clinet가 Connect를 할 때까지 대기 

			System.out.println("연결 성공");
			
			// 4. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			
			// 5. 데이터 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer); //blocking
			
			if(readByteCount == -1){
				System.out.println("[server] closed by client");
				return;
			} 
			String data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[server] receive: " + data);
			
		} catch (IOException e) {
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() ) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
