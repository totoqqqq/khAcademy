package day020;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("================\n1.�Է�\n2.��ȸ\n�޴��� ����ּ��� : ");
			switch(Integer.parseInt(scan.nextLine())) {
			case 1:
				new KHDAO().insert(new KHDTO(1007,"mint_Choco",5000,true));
				break;
			case 2:
				ArrayList<KHDTO> rsArr=new Controller().search(scan.nextLine());
				for(KHDTO kh:rsArr) {
					System.out.printf("%s\n%d\n",kh.getPname(),kh.getPrice());
				}
			}
		}
	}
}