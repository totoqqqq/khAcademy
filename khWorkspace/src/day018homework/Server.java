package day018homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	private final String IP = "192.168.150.9";
	final int PORT=23000;
	Server(){
		run();
	}
	@Override
	public void run() {
		final int PORT=23000;
		try(ServerSocket host = new ServerSocket(PORT);Socket server = new Socket(IP,PORT);DataOutputStream dos = new DataOutputStream(server.getOutputStream());DataInputStream dis = new DataInputStream(server.getInputStream())){
			
			while(true) {
				dos.writeUTF("ID를 입력해주세요.");
				host.accept();
				String id = dis.readUTF();
				dos.writeUTF("PASSWORD를 입력해주세요.");
				host.accept();
				String Password=dis.readUTF();
			}
		}catch(IOException e) {
			System.out.println("접속 실패");
		}
	}
}
