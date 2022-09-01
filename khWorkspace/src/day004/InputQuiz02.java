package day004;

import java.util.Scanner;

class InputQuiz02 {
	InputQuiz02(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int[] inputInt=new int[2];
		for(int i=0;i++<3;) {
			if(i>=3) {
				System.out.println("입력받은 "+inputInt[0]+" + "+inputInt[1]+" = "+(inputInt[0]+inputInt[1])+" 입니다.");
				break;
			}
			try {
				System.out.print(i+"번째 숫자를 입력해주세요. : ");
				inputInt[i-1]=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {
				System.out.println(i-- +"번째 입력을 잘못 입력하셨습니다. 21억 이내의 숫자로 입력해주세요.");
				continue;
			}
		}
	}
}