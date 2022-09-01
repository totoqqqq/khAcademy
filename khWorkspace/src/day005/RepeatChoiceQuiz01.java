package day005;

import java.util.Scanner;

class RepeatChoiceQuiz01 {
	RepeatChoiceQuiz01(){
		int i=0, maxCount, result=0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("===1 ~ n 까지의 합 구하기 ===\nn값 입력 : ");
		maxCount=Integer.parseInt(scan.nextLine());
		while(i++<maxCount)
			result+=i;
		System.out.println("n 값은 "+result);
	}
}