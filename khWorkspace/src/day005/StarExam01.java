package day005;

import java.util.Scanner;

class StarExam01 {
	StarExam01(){
		int inputSize;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.print("삼각형 높이를 입력해주세요.");
		inputSize=Integer.parseInt(scan.nextLine());
		//평면 전체 입력
//		for(int i=0;i<inputSize;i++) {
//			for(int j=0;j<inputSize;j++)
//				System.out.print("☆");	
//			System.out.println("");
//		}
		//1. 7시
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(i>=j)
					System.out.print("☆");
			}
			System.out.println("");
		}
		System.out.println("");
		//2. 10시
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(j-i>=0)
					System.out.print("☆");
			}
			System.out.println("");
		}
		System.out.println("");
		//3. 1시
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(i>j)
					System.out.print("ㅤ");
				else
					System.out.print("☆");
			}
			System.out.println("");
		}
		System.out.println("");
		//4. 4시
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(inputSize-1>j+i)
					System.out.print("ㅤ");
				else
					System.out.print("☆");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
