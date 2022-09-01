package day005;

import java.util.Scanner;

class SwitchExam {
	SwitchExam(){
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int select;
		System.out.print("골라줘요. 1.JAVA 2.음악 3.주짓수 ");
		select=Integer.parseInt(scan.nextLine());
		switch(select) {
		case 1:
			System.out.println("JAVA는 공학입니다.");
			break;
		case 2:
			System.out.println("음악은 예술입니다.");
			break;
		case 3:
			System.out.println("주짓수는 체육입니다.");
			break;
		default:
			System.out.println("메뉴를 다시 선택해주세요.");
			break;
		}
	}
}