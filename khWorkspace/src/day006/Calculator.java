package day006;

import java.util.Scanner;

class Calculator {
	Calculator(){
		int[] inputNum=new int[2];
		String operator;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("=== ���� ���α׷� ===\n");
		mainMenu:while(true) {
			while(true) {//������ & ���� �Է� ����
				System.out.print("������ �Է�(+,-,*,/,q-����)");
				operator = scan.nextLine();
				if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))
					break;
				else if(operator.equals("q")) {
					System.out.println("������ ���� �մϴ�.");
					break mainMenu;
				}
				else
					System.out.println("�ٽ� �Է����ּ���.");
			}
			for(int i=0;i<2;i++) {// ���� �Է� ����
				try {
					System.out.println(i+1+"��° ���� �Է� :");
					inputNum[i]=Integer.parseInt(scan.nextLine());
					if(inputNum[1]==0&&i==1)// n/0 ����
						System.out.println(inputNum[i--]+"���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
				}catch(NumberFormatException e) {// ���� �ǿ� �Է� ����
					System.out.println("���ڸ� �ٽ� �Է����ּ���.");
					i--;
				}
			}
			System.out.print("====== �� �� ======\n\n"+inputNum[0]+" "+operator+" "+inputNum[1]+" = ");//����
			switch(operator) {//��� ����
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
				System.out.printf("%.2f\n",((float)inputNum[0]/(float)inputNum[1]));//������ �Ҽ��� üũ.
				break;
			}
		}
	}
}