package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPIPMultiChatClient {
	
	public static void main(String[] args) {
		
		
		try {
			String serverIp = "192.168.0.32";   // localhost와같음 -> 호스트 자신
			// Socket 연결
			Socket socket = new Socket(serverIp, 7777);
			
			// 메시지를 받는 스레드
			Thread receiver = new ClientReceiver(socket);
			
			// 메시지를 보내는 스레드
			Thread sender = new ClientSenderThread(socket, "큠");
			
			sender.start();
			receiver.start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}


class ClientSenderThread extends Thread {
	
	// 보내기 스레드는 Socket, OutputStream, name 
	
	Socket socket;
	DataOutputStream out;
	String name;
	public ClientSenderThread(Socket s, String name) {
		this.socket = s;
		try {
			out = new DataOutputStream(s.getOutputStream());
			this.name = name;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
		// 접속하면 바로 이름을 서버에 전송
		if(out!=null) {
			out.writeUTF(name);
		}
		
		while(out!=null) {
			out.writeUTF("["+name+"] " + sc.nextLine());
		}
		} catch(IOException e) {
		}
		
	}
}
class ClientReceiver extends Thread{
	// 메시지를 받아서 콘솔에 출력
	// Socket, InputStream
	Socket socket;
	DataInputStream in;

	public ClientReceiver(Socket socket) {
		this.socket = socket;
		
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
		}
	
		
	}

	


	@Override
	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
			}
		}

		
	}
			
}
		
