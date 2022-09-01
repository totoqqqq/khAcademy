package day005;

import java.util.Scanner;

class RepeatQuiz01 {
	RepeatQuiz01(){
		int i=50;
		while(i<=100) {//int i를 50부터 100이하 까지 반복한다.
			if(i%2==1)//int i가 홀수 인 경우
				System.out.println("i : "+i);//int i를 출력한다.
			i++;//int i에 1을 증감한다.
		}
	}
}

class RepeatQuiz02{
	RepeatQuiz02(){
		int i=0;
		while(++i<=100) {
			if(i%5==0)
				System.out.println("짝 !("+(i/5)+")");
			else
				System.out.println(i);
		}
	}
}

class RepeatQuiz03{
	RepeatQuiz03(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputCount,i=0;
		System.out.print("메세지를 몇 번 출력하시겠습니까? ");
		inputCount=Integer.parseInt(scan.nextLine());
		while(i++<inputCount)
			System.out.println("Hello Java ("+(i)+")");
	}
}

class RepeatQuiz04{
	RepeatQuiz04(){
		final int GUGUMIN=2, GUGUMAX=9, COUNTMAX=9;//GUGUMIN : 최소 단수(기본 2단) GUGUMAX : 최대 단수 (기본 9단), COUNTMAX : 최대 곱하는수(기본n*9)
		int selectGugu, i=1;//selectGugu : 입력받는 단수
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("===구구단 출력 프로그램 ===\n\n"+GUGUMIN+" ~ "+GUGUMAX+" 단 중 선택 : ");
		while(true) {//1 ~ GUGUMAX(기본 9)단 입력 여부 검증.
			try {
				selectGugu = Integer.parseInt(scan.nextLine());
				if(selectGugu>=GUGUMIN&&selectGugu<=GUGUMAX)
					break;
				else
					System.out.print(GUGUMIN+" ~ "+GUGUMAX+" 단 범위를 벗어났습니다.\n"+GUGUMIN+" ~ "+GUGUMAX+" 단 중 선택 : ");
			}catch(NumberFormatException e) {
				System.out.print(GUGUMIN+" ~ "+GUGUMAX+" 단 범위를 벗어났습니다.\n"+GUGUMIN+" ~ "+GUGUMAX+" 단 중 선택 : ");
			}
		}
		System.out.println("");
		while(i<=COUNTMAX)//구구단 출력부
			System.out.println(selectGugu+" * "+i+" = "+(selectGugu*i++));
	}
}