package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClinet {

	public static void main(String[] args) {
		Socket socket = null;
		
		// 1. 소켓 생성
		socket = new Socket();
		
		try {
			// 2. 서버 연결
			socket.connect(new InetSocketAddress("192.168.0.8",54542));

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
				System.out.println("[client] closed by server");
				return ;
			}
			
			data = new String(buffer , 0, readByteCount, "utf-8");
			System.out.println("[clinet] received :" + data);
		} catch(SocketException e){ 
			System.out.println("[clinet] socket exception");
		} catch (IOException e) {
			System.out.println("[client] error :" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed() ) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
