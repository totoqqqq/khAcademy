package day008;

import java.util.Scanner;

public class ArrQuiz {
	Scanner scan = new Scanner(System.in);
	
	ArrQuiz(){
//		ArrQuiz01();
//		ArrQuiz02();
		ArrQuiz03();
	}
	
	@SuppressWarnings("unused")
	void ArrQuiz01(){
		char[] charArr = {'A','F','Z'},alphaArr=new char[26];
		String[] stringArr = {"Hello", "Array"};
		int[] intArr = new int[100];
		
//		for(int i=0;i<charArr.length;i++)
//			System.out.print(charArr[i]);
//		System.out.println();
//		for(int i=0;i<stringArr.length;i++)
//			System.out.print(stringArr[i]);
//		System.out.println();
		
//		for(int i=0;i<intArr.length;i++)
//			intArr[i]=intArr.length-i;
//		for(int i=0;i<intArr.length;i++)
//			System.out.println(intArr[i]);
		
		for(int i=0;i<alphaArr.length;i++)
			alphaArr[i]=(char)('A'+i);
		for(int i=0;i<alphaArr.length;i++)
			System.out.print(alphaArr[i]+" ");
		System.out.println("");
		for(int i=alphaArr.length;i>0;i--)
			System.out.print(alphaArr[i-1]+" ");
	}
	
	void ArrQuiz02(){
		final int INPUTHUMAN =3;
		String[] tag = {"이름","국어","영어","합계","평균"};
		String[] name = new String[INPUTHUMAN];
		int[][] score = new int[INPUTHUMAN][INPUTHUMAN];
		
		for(int i=0;i<INPUTHUMAN;i++) {
			System.out.print(i+1+"번쨰 학생 이름 :");
			name[i]=scan.nextLine();
			try {
				System.out.print(name[i]+" 학생 "+tag[1]+"점수 : ");
				score[0][i]=Integer.parseInt(scan.nextLine());
				if(score[0][i]<0)
					System.out.println(1+i-- +"번 학생 "+tag[1]+"점수 입력오류 입니다.");
				System.out.print(name[i]+" 학생 "+tag[2]+"점수 : ");
				score[1][i]=Integer.parseInt(scan.nextLine());
				if(score[1][i]<0)
					System.out.println(1+i-- +"번 학생 "+tag[2]+"점수 입력오류 입니다.");
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				i--;
			}
		}
				
		for(int i=0;i<tag.length;i++)
			System.out.print(tag[i]+"   ");
		System.out.println();
		for(int i=0;i<name.length;i++)
			System.out.println(name[i]+"   "+score[0][i]+"   "+score[1][i]+String.format("   %3.0f   ", ((float)score[0][i]+(float)score[1][i]))+String.format("%3.1f", (((float)score[0][i]+(float)score[1][i])/2)));
	}
	
	void ArrQuiz03() {
		int[] randomInt = new int[3];
		main:for(int i=0;i<randomInt.length;i++) {
			randomInt[i]=(int)(Math.random()*5)+1;
			for(int j=0;j<i;j++)
				if(randomInt[i]==randomInt[j]) {
					i--;
					continue main;
				}
		}
		for(int i=0;i<randomInt.length;i++)
			System.out.println((i+1)+"번째 카드 : "+randomInt[i]);
	}
}