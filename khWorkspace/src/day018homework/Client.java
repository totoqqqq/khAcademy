package day018homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
	private final String IP = "192.168.150.9",ID="java",PASSWORD="1q2w3e4r";
	private	final int PORT = 23000;
	
	Client(){
		run();
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		try(Socket server = new Socket(IP,PORT);DataOutputStream dos = new DataOutputStream(server.getOutputStream())){
			while(true) {
				DataInputStream dis = new DataInputStream(server.getInputStream());
				if(!dis.equals(null)) {
					System.out.println(dis.readUTF());
					dos.writeUTF(scan.nextLine());
					dos.flush();
				}
				this.wait(1000);
			}
		}catch(IOException | InterruptedException e) {
			System.out.println("접속 실패");
		}
	}
}