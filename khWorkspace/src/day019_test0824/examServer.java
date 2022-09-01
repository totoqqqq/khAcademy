package day019_test0824;

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
int port = 8888;
ServerSocket serverSocket = null;
DataInputStream dis = null;
DataOutputStream dos = null;
try {
serverSocket = new ServerSocket(port);
Socket clientSocket = serverSocket.accept();
InputStream in = new InputStream();
OutputStream out = new OutputStream();
dis = new DataInputStream(in);
dos = new DataOutputStream(out);
dos.writeUTF("[서버 연결 성공]");
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
String now = sdf.format(date);
dos.writeUTF("[현재시간] : "+now);
} catch (IOException e) {
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