package day005;

import java.util.Scanner;

class RepeatQuiz01 {
	RepeatQuiz01(){
		int i=50;
		while(i<=100) {//int i�� 50���� 100���� ���� �ݺ��Ѵ�.
			if(i%2==1)//int i�� Ȧ�� �� ���
				System.out.println("i : "+i);//int i�� ����Ѵ�.
			i++;//int i�� 1�� �����Ѵ�.
		}
	}
}

class RepeatQuiz02{
	RepeatQuiz02(){
		int i=0;
		while(++i<=100) {
			if(i%5==0)
				System.out.println("¦ !("+(i/5)+")");
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
		System.out.print("�޼����� �� �� ����Ͻðڽ��ϱ�? ");
		inputCount=Integer.parseInt(scan.nextLine());
		while(i++<inputCount)
			System.out.println("Hello Java ("+(i)+")");
	}
}

class RepeatQuiz04{
	RepeatQuiz04(){
		final int GUGUMIN=2, GUGUMAX=9, COUNTMAX=9;//GUGUMIN : �ּ� �ܼ�(�⺻ 2��) GUGUMAX : �ִ� �ܼ� (�⺻ 9��), COUNTMAX : �ִ� ���ϴ¼�(�⺻n*9)
		int selectGugu, i=1;//selectGugu : �Է¹޴� �ܼ�
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("===������ ��� ���α׷� ===\n\n"+GUGUMIN+" ~ "+GUGUMAX+" �� �� ���� : ");
		while(true) {//1 ~ GUGUMAX(�⺻ 9)�� �Է� ���� ����.
			try {
				selectGugu = Integer.parseInt(scan.nextLine());
				if(selectGugu>=GUGUMIN&&selectGugu<=GUGUMAX)
					break;
				else
					System.out.print(GUGUMIN+" ~ "+GUGUMAX+" �� ������ ������ϴ�.\n"+GUGUMIN+" ~ "+GUGUMAX+" �� �� ���� : ");
			}catch(NumberFormatException e) {
				System.out.print(GUGUMIN+" ~ "+GUGUMAX+" �� ������ ������ϴ�.\n"+GUGUMIN+" ~ "+GUGUMAX+" �� �� ���� : ");
			}
		}
		System.out.println("");
		while(i<=COUNTMAX)//������ ��º�
			System.out.println(selectGugu+" * "+i+" = "+(selectGugu*i++));
	}
}