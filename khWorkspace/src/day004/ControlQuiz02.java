package day004;

import java.util.Scanner;

class ControlQuiz02 {
	ControlQuiz02(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("1 ~ 100 ���� �Է� : ");
		int inputInt;
		try {
			inputInt = Integer.parseInt(scan.nextLine());
			if(inputInt>100||inputInt<=0) {
				System.out.println("1 ~ 100 ������ ���ڸ� �Է����ּ���. ���α׷� ����");
				System.exit(1);
			}
			else {
				if(inputInt%2==0)
					System.out.println("�Է��� �� "+inputInt+"��(��) ¦�� �Դϴ�.");
				else
					System.out.println("�Է��� �� "+inputInt+"��(��) Ȧ�� �Դϴ�.");
			}
		}catch(NumberFormatException e){
			System.out.println("1 ~ 100 ������ ���ڸ� �Է����ּ���. ���α׷� ����");
			System.exit(1);
		}
	}
}