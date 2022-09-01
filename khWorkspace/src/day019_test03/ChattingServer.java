package day019_test03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChattingServer {
	public void chattingServer() {
		int port = 8888;//원인 1. 서버포트
		ServerSocket serverSocket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			serverSocket = new ServerSocket(port);//원인 1. 서버포트
			Socket clientSocket = serverSocket.accept();
			InputStream in = clientSocket.getInputStream();//원인 2. 인풋스트림의 인스턴스화를 시도하였습니다. //해결2. 올바른 생성방식으로 인풋스트림을 생성합니다. 
			OutputStream out = clientSocket.getOutputStream();//원인3. 아웃풋스트림의 인스턴스화를 시도하였습니다.//해결3. 올바른 생성방식으로 아웃스트림을 생성합니다.
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			dos.writeUTF("[서버 연결 성공]");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String now = sdf.format(date);
			dos.writeUTF("[현재시간] : "+now);
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}