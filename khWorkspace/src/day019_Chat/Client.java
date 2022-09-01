package day019_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	final private int PORT=25000;
	Socket client;
	BufferedReader br;
	PrintWriter pw;
	Scanner scan = new Scanner(System.in);
	Client(){
		try {
			String userName="";
			InetAddress localIP = InetAddress.getLocalHost();
			client = new Socket(localIP,PORT);
			pw=new PrintWriter(client.getOutputStream(),true);
			System.out.print("Chat Server Connected\nInput Your Name : ");
			userName=scan.nextLine();
			pw.print(userName);
			pw.flush();
			while(true) {
				String inputMassage=scan.nextLine();
				pw.print(inputMassage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}