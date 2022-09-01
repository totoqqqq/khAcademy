package day019_test03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChattingClient {
	public void chattingClient() {
		String serverIp = "127.0.0.1";
		int serverPort = 8888;//원인 1. 서버포트 // 해결 1. 서버측 서버소켓 포트번호 8888로 수정합니다.
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			socket = new Socket(serverIp, serverPort);//원인 1. 서버포트
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			String serverMsg = dis.readUTF();
			System.out.println(serverMsg);
			while(true) {//원인4. 클라이언트에서 서버측 메세지를 한번만 받고 종료 합니다. /해결 서버에서 값이 올떄까지 체크하다가 값이 오면 출력하고 끝나는 반복문을 넣어 줍니다.
				serverMsg = dis.readUTF();
				if(serverMsg!=null) {
					System.out.println(serverMsg);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}