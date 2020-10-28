package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TCPIPMultiChatServer {
	
	// 접속 사용자 정보를 저장: 메세지를 전체에게 보내기 위해
	// 저장 정보 : name, OutputStream
	// Map<String, Object>에 저장
	HashMap<String, Object> clients;
	
	public TCPIPMultiChatServer() {
		clients = new HashMap<String, Object>();
		Collections.synchronizedMap(clients);   // 스레드 동기화에 대해 안전하게 사용할 수 있도록 하는 메서드
	}
	
	public void start() throws IOException {
		
		// ServerSocket 실행
		// 사용자의 요청이 있으면 Socket 생성해서
		//  연결 -> clients 사용자 정보를 저장 => 스레드로 처리
		
		// 서버소켓 생성
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println("Chatting Server Start..!!");
		
		Socket socket = null;
		
		while(true) {
		// 요청이 들어올 때까지 대기하다 요청이 들어오면 새로운 Socket 생성해서 반환
		socket = serverSocket.accept(); 
		// map에 정보 저장, 접속한 사용자들에게 메세지를 전송
		System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"] 사용자 접속");
		
		ServerReceiver receiver = new ServerReceiver(socket);
		receiver.start();
		}

		
	}
	
	
	void sendToAll(String msg) {
		// 일괄처리, Map은 순서가 없음. -> Map Key -> Set
		Set<String> keys = clients.keySet();
		Iterator<String> itr = keys.iterator();
		
		while(itr.hasNext()) {
			DataOutputStream out = (DataOutputStream) clients.get(itr.next());
			
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 내부 클래스 (이벤트 처리할 때 씀. private으로 구성할 수도 있음) : 데이터 받아서 저장, 메시지 전체 발송
	private class ServerReceiver extends Thread{
		// Socket, InputStream, OutputStream
		Socket socket;
		DataOutputStream out;
		DataInputStream in;
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				out=new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}	

			@Override
			public void run() {
				
				String name = null; // 접속한 사용자의 이름
				try {
					name = in.readUTF();     // 이름을 스트림을 통해 받는다.
					clients.put(name, out);  // map에 사용자 정보 저장
					sendToAll(">>>>>>>> " +name+"님이 접속하셨습니다.");  // 내부(inner) 클래스에서는 외부(outer) 클래스의 멤버를 참조할 수 있다.
				
					while(in!=null) {
						sendToAll(in.readUTF());
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					clients.remove(name);
					System.out.println(name+"님이 나가셨습니다.");
				}

			}			

		}


	public static void main(String[] args) throws IOException {
		new TCPIPMultiChatServer().start();

	}	
}
