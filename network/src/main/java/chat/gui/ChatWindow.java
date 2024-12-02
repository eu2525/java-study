package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

import chat.ChatClient;
import chat.ChatServer;

public class ChatWindow {
	private Socket socket;
	private static final String SERVER_IP = "127.0.0.1";
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// 1. 서버 연결 작업
		try {
			// socket 생성
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			// 2. IO Stream 세팅
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 3. JOIN Protocol
			// join 프로토콜
		    pw.println("join:" + frame.getTitle());
		    String response = br.readLine();
		    System.out.println(response);
		    
			// 4. ChatClientThread 생성
			ChatClientThread chatClientThread = new ChatClientThread(br);
			chatClientThread.start();
		
			// Button
			buttonSend.setBackground(Color.GRAY);
			buttonSend.setForeground(Color.WHITE);
			// Observer 패턴이 사용됨.
			buttonSend.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent ) {
					sendMessage(pw);
				}
			});
			
			//buttonSend.addActionListener(actionEvent -> {});
			
			// Textfield
			textField.setColumns(80);
			textField.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					char keyChar = e.getKeyChar();
					if(keyChar == KeyEvent.VK_ENTER) {
						sendMessage(pw);
					}
				}
			});
			
			// Pannel
			pannel.setBackground(Color.LIGHT_GRAY);
			pannel.add(textField);
			pannel.add(buttonSend);
			frame.add(BorderLayout.SOUTH, pannel);
	
			// TextArea
			textArea.setEditable(false);
			frame.add(BorderLayout.CENTER, textArea);
	
			// Frame
			frame.addWindowListener(new WindowAdapter() {
				// Frame을 끄기 위한 조건
				public void windowClosing(WindowEvent e) {
					finish(chatClientThread, pw);
				}
			});
			frame.setVisible(true);
			frame.pack();
		} catch(SocketException e){ 
			System.out.println("socket exception" + e);
		} catch (IOException e) {
			System.out.println("socket exception" + e);
		}
	}
	
	private void sendMessage(PrintWriter pw) {
		String message = textField.getText();
		String requestMessage = encodeMessage(message);
		pw.println("message:" + requestMessage);
		
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
    private void finish(ChatClientThread chatClientThread, PrintWriter pw) {
    	// Syn
	    pw.println("quit");
	    // Thread 종료 전까지 대기
	    try {
	    	// ACK 듣고 Thread 종료.
	        chatClientThread.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	      
	    // Socket 종료 후 system out 
	    try {
	    	if (socket != null && !socket.isClosed() ) {
	    		socket.close();
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	System.exit(0);
	    }
   	}

	private static String encodeMessage(String input) {
		String encodedStr = Base64.getEncoder().encodeToString(input.getBytes());		
        return encodedStr;
	}

	// Inner Class를 생성해서 private으로 선언된 updateTextArea 함수를 사용 가능
	private class ChatClientThread extends Thread{
		private BufferedReader bufferedReader;

		public ChatClientThread(BufferedReader bufferedReader) {
			this.bufferedReader = bufferedReader; 
		}
		
		@Override
		 public void run() {
		     /* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
			try {
				while(true) {
					String request = bufferedReader.readLine();
					
					if ("quit ok".equals(request)) {
						ChatClient.log("closed by client");
						break;
					}
					
					updateTextArea(request);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Thread 종료 됌");
			}
		} 		
	}
}
