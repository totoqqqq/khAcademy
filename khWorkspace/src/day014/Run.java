package day014;

import java.util.ArrayList;

public class Run {
	private static ArrayList<Client> clis = new ArrayList<Client>();
	public static void main(String[] args) {
		System.out.println("���� ��ȣ �˻���...");
		for(int i=0;i<100;i++) {
			clis.add(new Client(0+(i*100)));
			clis.get(i).start();
		}
	}
}