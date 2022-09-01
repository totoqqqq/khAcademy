package day014;

import java.util.ArrayList;

public class Run {
	private static ArrayList<Client> clis = new ArrayList<Client>();
	public static void main(String[] args) {
		System.out.println("서버 암호 검색중...");
		for(int i=0;i<100;i++) {
			clis.add(new Client(0+(i*100)));
			clis.get(i).start();
		}
	}
}