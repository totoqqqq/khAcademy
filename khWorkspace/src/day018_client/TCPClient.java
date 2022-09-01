package day018_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class TCPClient {
	Socket client;
	BufferedReader br;
	PrintWriter pw;
	Scanner scan = new Scanner(System.in);
	TCPClient(){
		try {
			InetAddress localIP = InetAddress.getLocalHost();
			client=new Socket(localIP,25000);
			Receive re = new Receive();
			re.start();
			
			String UserID="";
			pw=new PrintWriter(client.getOutputStream(),true);
			System.out.print("Server Join\nCreate ID : ");
			pw.print(UserID);
			while(true) {
				String inputMassage = scan.nextLine()+"\n";
				pw.print(inputMassage);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	class Receive extends Thread{
		@Override
		public void run() {
			try {
				br=new BufferedReader(new InputStreamReader(client.getInputStream()));
				String massage=null;
				while(true) {
					massage=br.readLine();
					if(massage!=null)
						System.out.println(massage+"/n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
