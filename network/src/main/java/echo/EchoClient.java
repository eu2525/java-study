package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoClient {
	private static final String SERVER_IP = "192.168.0.8";
	public static void main(String[] args) {
		Socket socket = null;
		
		// 1. 소켓 생성
		socket = new Socket();
		
		try {
			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

			// 3. IO Stream 받아오기 
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 4. 쓰기
			String data = "Hello world";
			os.write(data.getBytes("utf-8"));
			
			// 5. 읽기 
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
				log("closed by server");
				return ;
			}
			
			data = new String(buffer , 0, readByteCount, "utf-8");
			log("received :" + data);
		} catch(SocketException e){ 
			log("socket exception");
		} catch (IOException e) {
			log("error :" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed() ) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void log(String message) {
		System.out.println("[Echo Client] " + message);
	}

}
