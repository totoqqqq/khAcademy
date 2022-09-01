package day006;

import java.util.Scanner;

class Calculator {
	Calculator(){
		int[] inputNum=new int[2];
		String operator;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 계산기 프로그램 ===\n");
		mainMenu:while(true) {
			while(true) {//연산자 & 종료 입력 검증
				System.out.print("연산자 입력(+,-,*,/,q-종료)");
				operator = scan.nextLine();
				if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))
					break;
				else if(operator.equals("q")) {
					System.out.println("계산기을 종료 합니다.");
					break mainMenu;
				}
				else
					System.out.println("다시 입력해주세요.");
			}
			for(int i=0;i<2;i++) {// 숫자 입력 검증
				try {
					System.out.println(i+1+"번째 숫자 입력 :");
					inputNum[i]=Integer.parseInt(scan.nextLine());
					if(inputNum[1]==0&&i==1)// n/0 검증
						System.out.println(inputNum[i--]+"으로 나눌 수 없습니다. 다시 입력해주세요.");
				}catch(NumberFormatException e) {// 숫자 의외 입력 검증
					System.out.println("숫자를 다시 입력해주세요.");
					i--;
				}
			}
			System.out.print("====== 결 과 ======\n\n"+inputNum[0]+" "+operator+" "+inputNum[1]+" = ");//연산
			switch(operator) {//결과 실행
			case "+":
				System.out.println(inputNum[0]+inputNum[1]);
				break;
			case "-":
				System.out.println(inputNum[0]-inputNum[1]);
				break;
			case "*":
				System.out.println(inputNum[0]*inputNum[1]);
				break;
			case "/":
				System.out.printf("%.2f\n",((float)inputNum[0]/(float)inputNum[1]));//나눗셈 소숫점 체크.
				break;
			}
		}
	}
}