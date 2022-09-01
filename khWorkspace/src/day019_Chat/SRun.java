package day019_Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SRun {
	public static void main(String[] args) {
		ExecutorService signInUser = Executors.newFixedThreadPool(10);
		final int PORT=25000;
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(PORT);
			while(true) {
				System.out.println("Waiting Connect");
				Server sers = new Server(server.accept());
				signInUser.submit(sers);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			signInUser.shutdown();
		}
	}
}