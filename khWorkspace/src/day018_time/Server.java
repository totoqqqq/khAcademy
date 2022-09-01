package day018_time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Server {
	@SuppressWarnings("unused")
	private final String IP = "192.168.150.9",PORT = "25000";
	Server(){
		try {
			ServerSocket server = new ServerSocket(Integer.parseInt(PORT));
			try(Socket socket=server.accept();ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());ObjectInputStream ois=new ObjectInputStream(socket.getInputStream())) {
				while(true) {
					switch(ois.readUTF()) {
					case"time":
						oos.writeUTF(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						oos.flush();
					case"lotto":
						String str=lotto();
						oos.writeUTF(str);
						oos.flush();
					case"speak":
						oos.writeUTF(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						oos.flush();
					default:
						oos.writeUTF("체크포인트");
						oos.flush();
					}
				}
			}catch(Exception e) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	String lotto() {
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		int number;
		lotto:while(true) {
			number=((int)(Math.random()*45)+1);
			if (lotto.size()!=0){
				for(int i:lotto) {
					if(i==number)
						continue lotto;
				}
			}
			lotto.add(number);
			if(lotto.size()==6)
				break;
		}
		String results=(String)(lotto.get(1)+" "+lotto.get(2)+" "+lotto.get(3)+" "+lotto.get(4)+" "+lotto.get(5)+" "+lotto.get(6));
		System.out.println(results);
		return results;
	}
}
