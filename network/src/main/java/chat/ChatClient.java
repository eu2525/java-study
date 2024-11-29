package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
import java.util.Scanner;

import echo.EchoServer;

public class ChatClient {
private static final String SERVER_IP = "192.168.0.8";
	
	public static void main(String[] args) {
		Scanner scanner = null; 
		Socket socket = null;
	
		try {
			// 키보드 연결
			scanner = new Scanner(System.in);
			// socket 생성
			socket = new Socket();
			// 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			// read/writer 객체 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// join 프로토콜
		    System.out.print("닉네임>>" );
		    String nickname = scanner.nextLine();
		    pw.println("join:" + nickname);
		    pw.flush();
		
			// ChatClientReceiveThread 시작
			ChatClientThread chatClientThread = new ChatClientThread(socket, br);
			chatClientThread.start();
			
		    // 키보드 입력 처리
			while(true) {
				String input = scanner.nextLine();
				
				if ("quit".equals(input)) {
					pw.println(input);
					
					// Thread가 종료될때까지 기다리는 blocking 코드를 추가
					try {
						chatClientThread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				} else {
					// base64로 인코딩하고
					String requestMessage = encodeMessage(input);
					// 인코딩한 메시지를 보내기
					pw.println("message:" + requestMessage);
				}
			}
		} catch(SocketException e){ 
			log("socket exception" + e);
		} catch (IOException e) {
			log("error :" + e);
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && !socket.isClosed() ) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private static String encodeMessage(String input) {
		String encodedStr = Base64.getEncoder().encodeToString(input.getBytes());		
        return encodedStr;
	}

	public static void log(String message) {
		System.out.println("[Chat Client] " + message);
	}
}
