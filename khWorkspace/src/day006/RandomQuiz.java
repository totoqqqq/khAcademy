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
		System.out.println("0 ~ 9������ ���� �� : "+(int)(Math.random()*10));
		System.out.println("1 ~ 10������ ���� �� : "+(int)(Math.random()*10+1));
		System.out.println("20 ~ 35������ ���� �� : "+(int)(Math.random()*16+20));
		System.out.println("0 �Ǵ� 1 : "+(int)(Math.random()*2));
	}
	
	void RandomQuiz02() {
		int coin, coinCheak;
		while(true) {
			coinCheak=(int)(Math.random()*2);
			System.out.print("=== ���� �� �� ���߱� ===\n���ڸ� �Է����ּ���(1.�ո�/2.�޸�)");
			try {
				coin=Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e) {
				break;
			}
			if (coin==coinCheak)
				System.out.println("������ϴ�.^^");
			else if(coin>2||coin<=0)
				break;
			else
				System.out.println("��! Ʋ�Ƚ��ϴ�.");
		}
	}
	
	void RandomQuiz03() {
		int yours, computer;
		String[] hand= {"����", "����", "��"};
		while(true) {
			computer=((int)(Math.random()*3)+1);
			System.out.print("=== ���� ���� �� ���� ===\n1.����, 2.����, 3.��, �̿��� ���� �� : ");
			try {//�������� �帧
				yours=Integer.parseInt(scan.nextLine());
				if(yours<=0||yours>3) {//�Է� ���� �ۿ� ���� �Է� �޴� ��� ���� ����
					System.out.println("\n============\n=�� �Է��ؼ� ��=\n============");
					break;
				}
			}catch(NumberFormatException e){//���� ���� ������ try ���� ������ �Ͼ�� ��� ��ġ �����ϰ� �帧 �̵�.
				System.out.println("\n===========\n=�� �Է��ؼ� ��=\n============");
				break;
			}
			System.out.print("\n======== ��� ========\nYOU'RE ");
			if(yours-computer==1||computer-yours==2)
				System.out.print("WINNER!");
			else if(yours==computer)
				System.out.print("TIE");
			else
				System.out.print("LOSER!");
			System.out.println("\n��� : "+hand[yours-1]+"\n��ǻ�� : "+hand[computer-1]+"\n====================\n");
		}
	}
}