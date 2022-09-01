package day010;

import java.util.Scanner;

class MethodCalculator {
	Scanner scan = new Scanner(System.in);
	MethodCalculator(){
		int[] inputNumber = new int[2];
		String operator;
		while(true) {
			while(true) {//������ & ���� �Է� ����
				System.out.print("������ �Է�(+,-,*,/,q-����)");
				operator = scan.nextLine();
				if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))
					break;
				else if(operator.equals("q")) {
					System.out.println("������ ���� �մϴ�.");
					System.exit(0);
				}
				System.out.println("�����ڸ� �Է����ּ���.");
			}
			inputNumber=Check(operator);
			excute(inputNumber,operator);
		}
	}
	int[] Check(String operator) {
		int [] inputNumber = new int[2];
		for(int i=0;i<inputNumber.length;i++) {
			try {
				System.out.print(1+i+"��° ���ڸ� �Է����ּ���. : ");
				inputNumber[i]=Integer.parseInt(scan.nextLine());
				if(operator.equals("/")&&inputNumber[1]==0&&i==1)
					System.out.println(1+i-- + "��° ���ڸ� �ٽ� �Է����ּ���.(0���� ���� �� �����ϴ�.)");
			}catch(NumberFormatException e) {
				System.out.println(1+i-- + "��° ���ڸ� ����� �Է����ּ���.");
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