package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1.소켓 객체 생성
			serverSocket = new ServerSocket();
			
			// 1-1. FIN_WAIT -> TIME_WAIT 상태에서도 소켓의 포트 할당이 가능하도록 하는 옵션
			serverSocket.setReuseAddress(true);
			
			// 2. 바인딩(Binding)
			// 		    여기에 넣는 IP는 어떤 ip가 Connect를 할 수 있는지를 적는거임
			// 		    Socket에 InetSocketAddress[InetAddress(IPAddress) + port]를 바인딩한다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 54542));

			// 3. accept
			Socket socket = serverSocket.accept(); // blocking  -> Clinet가 Connect를 할 때까지 대기 

			try {
				// 반대편 소켓의 정보를 가져옴 + 다운캐스팅 진행.
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by clinet[" +remoteHostAddress +":" + remotePort + "]");
				
				// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); //blocking
					if(readByteCount == -1){
						System.out.println("[server] closed by client");
						break;
					}
				
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] receive: " + data);					
					
					// 6. 데이터 쓰기
					// SO_TIMEOUT 테스트
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					os.write(data.getBytes("utf-8"));
					
				}
			
			} catch(SocketException e){ 
				System.out.println("[clinet] socket exception");
			} catch (IOException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					if(socket != null && !socket.isClosed() ) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("[server] error:" + e);
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
}
