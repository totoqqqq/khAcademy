package day004;

import java.util.Scanner;

class InputExam04 {
	InputExam04(){
		try {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("+-21�� ���� ���ڸ� �־��ּ���. : ");
		String inputString = scan.nextLine();
		System.out.println(Integer.parseInt(inputString)+10);
		}catch(NumberFormatException e){
			System.out.println("�������� ���ڸ� �־��ּ���.(������ ���� ����)");
			System.exit(1);
		}
	}
}
