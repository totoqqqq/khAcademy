package day004;

import java.util.Scanner;

class InputQuiz02 {
	InputQuiz02(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int[] inputInt=new int[2];
		for(int i=0;i++<3;) {
			if(i>=3) {
				System.out.println("�Է¹��� "+inputInt[0]+" + "+inputInt[1]+" = "+(inputInt[0]+inputInt[1])+" �Դϴ�.");
				break;
			}
			try {
				System.out.print(i+"��° ���ڸ� �Է����ּ���. : ");
				inputInt[i-1]=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {
				System.out.println(i-- +"��° �Է��� �߸� �Է��ϼ̽��ϴ�. 21�� �̳��� ���ڷ� �Է����ּ���.");
				continue;
			}
		}
	}
}