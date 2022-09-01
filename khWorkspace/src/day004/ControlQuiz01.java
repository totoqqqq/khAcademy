package day004;

import java.util.Scanner;

class ControlQuiz01 {
	ControlQuiz01(){
		int[] inputInt = new int[2];
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<2;i++) {
			try {
				System.out.print(i+1+"번째 숫자를 입력 : ");
				inputInt[i]=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e){
				System.out.println("====숫자만 입력해주세요.====");
				i--;
			}
		}
		System.out.println("\n==== 결 과 ====\n");
		if(inputInt[0]>inputInt[1])
			System.out.println("첫 번 째 입력 한 "+inputInt[0]+" 값이 더 크다.");
		else if(inputInt[0]<inputInt[1])
			System.out.println("두 번 째 입력 한 "+inputInt[1]+" 값이 더 크다.");
		else
			System.out.println("동 일 한 "+inputInt[0]+" 값을 입력 받았다.");
	}
}