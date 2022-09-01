package day018_time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private final String IP = "192.168.150.9",PORT = "25000";
	Client(){
		try(Socket client = new Socket(IP,Integer.parseInt(PORT));ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());ObjectInputStream ois = new ObjectInputStream(client.getInputStream());) {
			Scanner scan=new Scanner(System.in);
			while(true) {
				System.out.println("<<메뉴를 선택하세요>>\n1. 현재 서버시간\n2. 금주의 로또 번호 \n3. 오늘의 명언");
				String select = scan.nextLine();
				switch(select) {
				case "1":
					oos.writeUTF("time");
					oos.flush();
					break;
				case "2":
					oos.writeUTF("lotto");
					oos.flush();
					break;
				case "3":
					oos.writeUTF("speak");
					oos.flush();
					break;
				}
//				System.out.println(ois.readUTF());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}