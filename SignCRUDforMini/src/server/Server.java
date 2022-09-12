package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	@SuppressWarnings("unused")
	private final String HOMEIP="172.28.128.1", IP = "192.168.150.32",PORT = "25000";
	private Socket client;
	Server(){
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket();
			server.bind(new InetSocketAddress(Integer.parseInt(PORT)));
			client = server.accept();
			main:while(true) {
				try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
					BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
					InputStream is = client.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is)){
					SignMemberDAO smDAO;
					String selectMenu=null;
					while(true) {
						pw.println("#main");
						pw.flush();
						selectMenu = br.readLine();
						menu:while(selectMenu!=null) {
							switch(selectMenu) {
							case "1":
								pw.println("#login");
								pw.flush();
								SignMember sm=null;
								smDAO=SignMemberDAO.getInstance();
								int loginCheck=0;
								while(true) {
									if(sm==null)
										sm = (SignMember) ois.readObject();
									else
										break;
								}
								loginCheck=smDAO.login(sm);
								if(loginCheck==1)
									pw.println("#true");
								else
									pw.println("#false");
								pw.flush();
								selectMenu=null;
								break menu;
							case "2":
								pw.println("#signup");
								pw.flush();
								SignMember suSm=null;
								int check=0;
								while(true) {
									if(suSm==null)
										suSm = (SignMember) ois.readObject();
									else
										break;
								}
								smDAO=SignMemberDAO.getInstance();
								check=smDAO.createSign(suSm);
								if(check==1)
									pw.println("#true");
								else
									pw.println("#false");
								pw.flush();
								selectMenu=null;
								break menu;
							case "10":
								selectMenu=null;
								break main;
							default:
								selectMenu=null;
								break menu;
							}
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException | IOException e) {	
			e.printStackTrace();
		}
	}
}