package day004;

import java.util.Scanner;

class InputQuiz01 {
	InputQuiz01(){
		String[] infoData = new String[2];
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.print("<< 방문록 >>\n이름과 연락처를 작성해주세요.\n이름 : ");
		infoData[0]=scan.nextLine();
		System.out.print("연락처(휴대폰 번호) : ");
		infoData[1]=scan.nextLine();
		System.out.println("====================\n저는 "+infoData[0]+" 입니다.\n"+infoData[1]+" 로 연락 주세요.");
	}
}
