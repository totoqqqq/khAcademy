package day004;

import java.util.Scanner;

class ControlQuiz02 {
	ControlQuiz02(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("1 ~ 100 사이 입력 : ");
		int inputInt;
		try {
			inputInt = Integer.parseInt(scan.nextLine());
			if(inputInt>100||inputInt<=0) {
				System.out.println("1 ~ 100 사이의 숫자만 입력해주세요. 프로그램 종료");
				System.exit(1);
			}
			else {
				if(inputInt%2==0)
					System.out.println("입력한 수 "+inputInt+"은(는) 짝수 입니다.");
				else
					System.out.println("입력한 수 "+inputInt+"은(는) 홀수 입니다.");
			}
		}catch(NumberFormatException e){
			System.out.println("1 ~ 100 사이의 숫자만 입력해주세요. 프로그램 종료");
			System.exit(1);
		}
	}
}