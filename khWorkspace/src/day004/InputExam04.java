package day004;

import java.util.Scanner;

class InputExam04 {
	InputExam04(){
		try {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("+-21억 이하 숫자를 넣어주세요. : ");
		String inputString = scan.nextLine();
		System.out.println(Integer.parseInt(inputString)+10);
		}catch(NumberFormatException e){
			System.out.println("범위내의 숫자를 넣어주세요.(오류로 인한 종료)");
			System.exit(1);
		}
	}
}
