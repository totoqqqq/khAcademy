package day018;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	public static void main(String[] args) {
		ExecutorService signInUser= Executors.newFixedThreadPool(10);
		try(ServerSocket server = new ServerSocket(25000)){
			while(true) {
				System.out.println("#Connect Waiting...");
				TCPServer tcps = new TCPServer(server.accept());
				signInUser.submit(tcps);
			}
		}catch(IOException e) {
			
		}
		System.out.println("Server Shutdown");
		signInUser.shutdown();
	}
}