package day007_test01;

import java.util.Scanner;

class UmaGame {
	private int money;
	Scanner scan = new Scanner(System.in);
	UmaGame(){
		int selectMenu;
		this.money=0;
		String[] gameMenu = {"���ӽ���","�ܾ�����","�ܾ���ȸ","��������"};
		while(true){
			line();
			System.out.println("<<<�渶 ���ӿ� ���Ű� ȯ���մϴ�.>>>");
			for(int i=0;i<4;i++)
				System.out.println(i+1+". "+gameMenu[i]);
			try {
				System.out.print("�޴��� �������ּ���.\n>>");
				selectMenu=Integer.parseInt(scan.nextLine());
				line();
				switch(selectMenu) {
				case 1:
					StartUmaGame();
					break;
				case 2:
					InputUmaCash();
					break;
				case 3:
					ViewUmaCash();
					break;
				case 4:
					System.out.println("���α׷��� ���� �մϴ�.");
					System.exit(0);
				default:
					System.out.println("��ȣ�� ����� �Է����ּ���.");
				}
			}catch(NumberFormatException e){
				System.out.println("��ȣ�� ����� �Է����ּ���.");
			}
		}
	}
	
	void StartUmaGame() {
		while(true) {
			int money=this.money, selectUma, inputMoney, winUma=(int)(Math.random()*3)+1;
			line();
			System.out.println("������ �����մϴ�. (���� ���� �ݾ��� "+money+"�� �Դϴ�.)");
			if(money==0) {
				System.out.println("�����ݾ��� �����ż� �ڵ� ���� �մϴ�. ���� ���ּ���.");
				break;
			}
			System.out.print("1. ��°���� ������ ���� �յ� ��\n2. �̹� �� ������ ���� ���� ��\n3. �ֱ� �������� �ſ��� ��\n���� �ϰ� ���� ���� �������ּ���.>>");
			try {
				selectUma=Integer.parseInt(scan.nextLine());
				if(selectUma<=0||selectUma>3) {
					System.out.println("�� ��ȣ�� ����� ����ּ���.");
					continue;
				}
				while(true) {
					System.out.print("�󸶸� ���� �Ͻðڽ���?(�ִ��ѵ�"+money+"��):");
					inputMoney=Integer.parseInt(scan.nextLine());
					line();
					if(money<inputMoney)
						System.out.println("�ܾ��� �����մϴ�.");
					else if(inputMoney<=0)
						System.out.println("1�� �̻� �����ؾ� �˴ϴ�.");
					else {
						this.money-=inputMoney;
						break;
					}
				}
				if(selectUma==winUma) {
					this.money+=(inputMoney*2);
					System.out.println(selectUma+"�� ���� ����Ͽ����ϴ�.\n���ÿ� �����Ͽ����ϴ�..!\n������ �ݾ��� 2���� "+inputMoney*2+"���� ȹ���Ͽ����ϴ�.");
					break;
				}
				else {
					System.out.println(winUma+"�� ���� ����Ͽ����ϴ�.\n���ÿ� �����Ͽ����ϴ�...^^\n������ �ݾ��� "+inputMoney+"���� ��� �����̽��ϴ�.");
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println("���ڸ� ����� �Է����ּ���.");
			}
		}
	}
	
	void InputUmaCash() {
		int money=this.money, inputmoney;
		while(true) {
			try {
				System.out.print("�󸶸� �����Ͻðڽ��� ?");
				inputmoney=Integer.parseInt(scan.nextLine());
				if(money < -inputmoney)
					System.out.println("�ܾ��� �����Ͽ� ��� �Ұ��մϴ�.");
				else if(inputmoney<=0){
					System.out.println(inputmoney+"�� ��� �Ǿ����ϴ�.");
					this.money+=inputmoney;
					break;
				}
				else {
					System.out.println(inputmoney+"���� �����Ǿ����ϴ�.");
					this.money+=inputmoney;
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println("����� �� �ݾ��� �Է����ּ���.");
			}
		}
	}
	
	void ViewUmaCash() {
		int money=this.money;
		System.out.println("���� �ܾ��� :"+money+"�� �Դϴ�.");
	}
	

	void line() {
		for(int i=0;i<90;i++)
			System.out.print("-");
		System.out.println("");
	}
}