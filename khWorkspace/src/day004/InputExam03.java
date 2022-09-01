package day004;

import java.util.Scanner;//Scanner import.

class InputExam03 {
	InputExam03(){
		@SuppressWarnings("resource")//Scanner 인스턴스 scan의 resource 경고를 무시시키기
		Scanner scan = new Scanner(System.in);//Scanner 클래스의 인스턴스 scan 생성.
		String inputString;
		for(int i=0;i++<2;) {
			System.out.print("문자열을 입력해주세요. : ");
			inputString=scan.nextLine();
			System.out.println("입력받은 값 : "+inputString);
		}
	}
}