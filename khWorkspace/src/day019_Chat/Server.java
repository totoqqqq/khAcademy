package day019_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{
	private Socket client;
	private static ArrayList<Socket> userList = new ArrayList<Socket>();
	private static int userIndex=0;
	Server(Socket client){
		System.out.println("unknown user Connected");
		this.client=client;
		userList.add(this.client);
	}
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			PrintWriter pw = new PrintWriter(this.client.getOutputStream(),true);
			userIndex++;
			String userName=null, inputText="";
			while(true) {
				userName=br.readLine();
				System.out.println(userName);
				if(!userName.equals(null)) {
					System.out.println(userName+"123");
					break;
				}
			}
			System.out.printf("[%d][%s]님이 접속하였습니다.",userIndex,userName);
			while(true) {
				inputText=br.readLine();
				if(inputText!=null) {
					pw.print(userName+" : "+inputText);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
