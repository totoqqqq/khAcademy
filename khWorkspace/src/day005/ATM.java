package day005;

import java.util.Scanner;

class ATM {
	private int money;//�߿䵥���ͷ� �������� �ܺο��� ���������� ����.
	Scanner scan = new Scanner(System.in);
	String[] atmMenu = {"�ܾ���ȸ","�Ա��ϱ�","����ϱ�","�����ϱ�"};
	ATM(){
		int selectMenu;
		this.money=0;
		mainMenu:while(true) {
			System.out.println("***ATM �ùķ�����***");
			for(int i=0;i<atmMenu.length;i++)
				System.out.println(i+1+" . "+atmMenu[i]);
			selectMenu=Integer.parseInt(scan.nextLine());
			switch(selectMenu) {
			case 1:
				checkBalance();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				break mainMenu;
			default:
				System.out.println("������ �ٽ����ּ���.");
				break;
			}
		}
	}
	
	void checkBalance() {//��ȸ�ϱ� ������.
		int money=this.money;
		System.out.println("���� �����ܾ��� "+money+"�� �Դϴ�.");
	}
	
	void deposit() {//�Ա��ϱ� ������.
		int money;
		while(true) {
			System.out.print("�Ա��� �ݾ��� �Է����ּ���. (0�� �Է½� ���):");
			money=Integer.parseInt(scan.nextLine());
			if(money<1) {
				if(money==0) {
					System.out.println("�Ա��� ����ϼ̽��ϴ�.");
					break;
				}
				else
					System.out.println("1�� �̻� �Ա��ϼž� �˴ϴ�.");
			}
			else {
				this.money+=money;
				System.out.println(money+"���� �ԱݵǾ����ϴ�.");
				break;
			}
		}
	}
	
	void withdraw() {//����ϱ� ������.
		int money;
		while(true) {
			System.out.print("����� �ݾ��� �Է����ּ���. (0�� �Է½� ���):");
			money=Integer.parseInt(scan.nextLine());
			if(money<1) {
				if(money==0) {
					System.out.println("����� ����ϼ̽��ϴ�.");
					break;
				}
				else
					System.out.println("1�� �̻� ����ϼž� �˴ϴ�.");
			}
			else {
				if(this.money>=money) {
					this.money-=money;
					System.out.println(money+"���� ��ݵǾ����ϴ�.");
					break;
				}
				else
					System.out.println("���¿� �����Ͻ� �ݾ��� �����Ͽ� ����� ��ҵǾ����ϴ�.");
			}
		}
	}
}