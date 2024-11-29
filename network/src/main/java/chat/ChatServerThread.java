package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;
	
	public ChatServerThread( Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		// 객체에 대한 주소 값을 전달하는거임.
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			ChatServer.log("connected by client[" +remoteHostAddress +":" + remotePort + "]");
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 3. 요청 처리
			while(true) {
				String request = br.readLine();
				
				if(request == null){
					ChatServer.log("closed by client[" + remoteHostAddress +":" + remotePort + "]");
					break;
				}	
				
				String[] tokens = request.split( ":" );
				if( "join".equals( tokens[0] ) ) {
					// pw를 날리는 건 이제 등록한 사람한테 join 되었다고 메시지를 보내기 위해서
					doJoin(tokens[1], pw);
				} else if( "message".equals(tokens[0])) {
					// base64로 디코딩하기
					String message = decodeMessage(tokens[1]);
					doMessage(message);
				} else if( "quit".equals(tokens[0])) { 
					doQuit(pw);
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch(SocketException e){ 
			System.out.println("socket exception" + e);
		} catch (IOException e) {
			System.out.println("error" + e);
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

	private String decodeMessage(String rawRequest) {
		byte[] decodedBytes = Base64.getDecoder().decode(rawRequest);
        String decodedStr = new String(decodedBytes);
		
        return decodedStr;
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장하였습니다."; 
		broadcast( data );
		// ack
		((PrintWriter) writer).println("quit ok");
	}

	private void removeWriter(Writer writer) {
		synchronized( listWriters ) {
			listWriters.removeIf(item -> item.equals(writer));
		}
	}

	private void doMessage(String message) {
		broadcast(this.nickname + ":" +message);
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다."; 
		broadcast(data);
		/* writer pool에  저장 */
		addWriter(writer);
		// ack
		((PrintWriter) writer).println( "join:ok" );
		((PrintWriter) writer).flush();

	}
	
	private void addWriter( Writer writer ) {
		synchronized( listWriters ) {
			listWriters.add(writer);
		}
	}
	
	 private void broadcast( String data ) {
		synchronized( listWriters ) {
			for( Writer writer : listWriters ) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
		    }
		}
	}
}
