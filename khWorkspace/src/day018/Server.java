package day018;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
	@SuppressWarnings("unused")
	private final String IP = "192.168.150.9",PORT = "25000";
	private Socket socket;
	Server(){
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			ServerSocket server = new ServerSocket(Integer.parseInt(PORT));
			socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.println(socket.getInetAddress()+"에서의 접속이 확인 되었습니다. 보낼 메세지를 입력해주세요.");
			dos.writeUTF(scan.nextLine());
			dos.flush();
			
		} catch (NumberFormatException | IOException e) {	
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}