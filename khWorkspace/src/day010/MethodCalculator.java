package day010;

import java.util.Scanner;

class MethodCalculator {
	Scanner scan = new Scanner(System.in);
	MethodCalculator(){
		int[] inputNumber = new int[2];
		String operator;
		while(true) {
			while(true) {//연산자 & 종료 입력 검증
				System.out.print("연산자 입력(+,-,*,/,q-종료)");
				operator = scan.nextLine();
				if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))
					break;
				else if(operator.equals("q")) {
					System.out.println("계산기을 종료 합니다.");
					System.exit(0);
				}
				System.out.println("연산자를 입력해주세요.");
			}
			inputNumber=Check(operator);
			excute(inputNumber,operator);
		}
	}
	int[] Check(String operator) {
		int [] inputNumber = new int[2];
		for(int i=0;i<inputNumber.length;i++) {
			try {
				System.out.print(1+i+"번째 숫자를 입력해주세요. : ");
				inputNumber[i]=Integer.parseInt(scan.nextLine());
				if(operator.equals("/")&&inputNumber[1]==0&&i==1)
					System.out.println(1+i-- + "번째 숫자를 다시 입력해주세요.(0으로 나눌 수 없습니다.)");
			}catch(NumberFormatException e) {
				System.out.println(1+i-- + "번째 숫자를 제대로 입력해주세요.");
			}		
		}
		return inputNumber;
	}
	void excute(int[] inputNumber,String operator) {
		switch(operator) {
		case "+":
			System.out.printf("%d "+operator+" %d = %d\n",inputNumber[0],inputNumber[1],inputNumber[0]+inputNumber[1]);
			break;
		case "-":
			System.out.printf("%d "+operator+" %d = %d\n",inputNumber[0],inputNumber[1],inputNumber[0]-inputNumber[1]);
			break;
		case "*":
			System.out.printf("%d "+operator+" %d = %d\n",inputNumber[0],inputNumber[1],inputNumber[0]*inputNumber[1]);
			break;
		case "/":
			System.out.printf("%d "+operator+" %d = %.2f\n",inputNumber[0],inputNumber[1],((double)inputNumber[0])/inputNumber[1]);
			break;
		}
	}
}