package day004;

import java.util.Scanner;

class ControlQuiz01 {
	ControlQuiz01(){
		int[] inputInt = new int[2];
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<2;i++) {
			try {
				System.out.print(i+1+"��° ���ڸ� �Է� : ");
				inputInt[i]=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e){
				System.out.println("====���ڸ� �Է����ּ���.====");
				i--;
			}
		}
		System.out.println("\n==== �� �� ====\n");
		if(inputInt[0]>inputInt[1])
			System.out.println("ù �� ° �Է� �� "+inputInt[0]+" ���� �� ũ��.");
		else if(inputInt[0]<inputInt[1])
			System.out.println("�� �� ° �Է� �� "+inputInt[1]+" ���� �� ũ��.");
		else
			System.out.println("�� �� �� "+inputInt[0]+" ���� �Է� �޾Ҵ�.");
	}
}