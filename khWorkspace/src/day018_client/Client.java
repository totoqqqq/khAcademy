package day018_client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;

class Client extends Thread{
	final String HOSTIP= "192.168.150.13", TESTIP="192.168.150.9", PORT="25000";
	Client(){
		try {
//			Socket client = new Socket(HOSTIP,Integer.parseInt(PORT));
			@SuppressWarnings("resource")
			Socket client = new Socket(TESTIP,Integer.parseInt(PORT));
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(client));
			
			System.out.println("서버로 부터 온 메세지"+dis.readUTF());
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}