package day005;

import java.util.Scanner;

class SwitchExam {
	SwitchExam(){
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int select;
		System.out.print("������. 1.JAVA 2.���� 3.������ ");
		select=Integer.parseInt(scan.nextLine());
		switch(select) {
		case 1:
			System.out.println("JAVA�� �����Դϴ�.");
			break;
		case 2:
			System.out.println("������ �����Դϴ�.");
			break;
		case 3:
			System.out.println("�������� ü���Դϴ�.");
			break;
		default:
			System.out.println("�޴��� �ٽ� �������ּ���.");
			break;
		}
	}
}