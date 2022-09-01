package day018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class TCPServer implements Runnable {
	private static Socket client;
	static PrintWriter out = null;
	static ArrayList<Socket> connectingList = new ArrayList<Socket>();
	static int userIndex = 0;
	
	@SuppressWarnings("static-access")
	TCPServer(Socket client){
		System.out.println("#Connect");
		this.client=client;
		connectingList.add(this.client);
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
			userIndex++;
			System.out.println();
			String userID = br.readLine();
			String inputText=null;
			pw.printf("[%s][%s]님이 연결되었습니다.\n",userIndex,userID);
			System.out.printf("[%s]님이 접속하였습니다.\n",userID);
			while(true){
				inputText=br.readLine();
				if(!inputText.equals(null)) {
					for(int i=0;i<connectingList.size();i++) {
						pw=new PrintWriter(connectingList.get(i).getOutputStream(),true);
						pw.print(userID+" : "+inputText+"\n");
						pw.flush();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Client : "+Thread.currentThread()+"Logout");
		}
		
	}
}