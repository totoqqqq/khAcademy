package day005;

import java.util.Scanner;

class InfinityRepeatExam01 {
	InfinityRepeatExam01(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputNum=0,sum=0;
		while(true) {
			System.out.print("수 입력 (0:종료) : ");
			inputNum=Integer.parseInt(scan.nextLine());
			if(inputNum==0)
				break;
			sum+=inputNum;
		}
		System.out.print("입력한 값들의 합은 : "+sum);
	}
}