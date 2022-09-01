package day006;

import java.util.Scanner;

class RandomQuiz {
	Scanner scan = new Scanner(System.in);
	RandomQuiz(){
//		RandomQuiz01();
//		RandomQuiz02();
		RandomQuiz03();
	}
	
	void RandomQuiz01() {
		System.out.println("0 ~ 9까지의 랜덤 수 : "+(int)(Math.random()*10));
		System.out.println("1 ~ 10까지의 랜덤 수 : "+(int)(Math.random()*10+1));
		System.out.println("20 ~ 35까지의 랜덤 수 : "+(int)(Math.random()*16+20));
		System.out.println("0 또는 1 : "+(int)(Math.random()*2));
	}
	
	void RandomQuiz02() {
		int coin, coinCheak;
		while(true) {
			coinCheak=(int)(Math.random()*2);
			System.out.print("=== 동전 앞 뒤 맞추기 ===\n숫자를 입력해주세요(1.앞면/2.뒷면)");
			try {
				coin=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {
				break;
			}
			if (coin==coinCheak)
				System.out.println("맞췄습니다.^^");
			else if(coin>2||coin<=0)
				break;
			else
				System.out.println("땡! 틀렸습니다.");
		}
	}
	
	void RandomQuiz03() {
		int yours, computer;
		String[] hand= {"가위", "바위", "보"};
		while(true) {
			computer=((int)(Math.random()*3)+1);
			System.out.print("=== 가위 바위 보 게임 ===\n1.가위, 2.바위, 3.보, 이외의 선택 펑 : ");
			try {//정상적인 흐름
				yours=Integer.parseInt(scan.nextLine());
				if(yours<=0||yours>3) {//입력 범위 밖에 수를 입력 받는 경우 오류 검출
					System.out.println("\n============\n=오 입력해서 펑=\n============");
					break;
				}
			}catch(NumberFormatException e){//숫자 포멧 오류가 try 범위 내에서 일어나는 경우 위치 무시하고 흐름 이동.
				System.out.println("\n===========\n=오 입력해서 펑=\n============");
				break;
			}
			System.out.print("\n======== 결과 ========\nYOU'RE ");
			if(yours-computer==1||computer-yours==2)
				System.out.print("WINNER!");
			else if(yours==computer)
				System.out.print("TIE");
			else
				System.out.print("LOSER!");
			System.out.println("\n당신 : "+hand[yours-1]+"\n컴퓨터 : "+hand[computer-1]+"\n====================\n");
		}
	}
}