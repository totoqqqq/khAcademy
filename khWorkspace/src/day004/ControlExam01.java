package day004;

import java.util.Scanner;

class ControlExam01 {
	ControlExam01(){
		String[][] fruit = {{"사과","망고","포도"},{"Apple","Mango","Grape"}};
		int select;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("당신이 좋아하는 과일을 선택하세요.");
		for(int i=0;i<fruit[0].length;i++)
			System.out.println(i+1+". "+fruit[0][i]);
		while(true){
			try {
				select=Integer.parseInt(scan.nextLine());
				if(select>fruit[0].length||select<=0)
					System.out.println("보기의 숫자만 입력해주세요.");
				else
					break;
			}catch(NumberFormatException e){
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
		}
		System.out.println(fruit[0][select-1]+"는 영어로 "+fruit[1][select-1]+" 입니다.");
	}
}