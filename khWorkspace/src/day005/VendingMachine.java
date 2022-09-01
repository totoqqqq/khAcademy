package day005;

import java.util.Scanner;

public class VendingMachine {
	private String[] itemList = {"�ݶ�","���̴�","�Ž���"};
	private int[] price = {1000,800,1500};
	private int[] inventory = {0,0,0};
	private int money;
	Scanner scan = new Scanner(System.in);
	VendingMachine(){
		int selectMenu;
		this.money=3000;
		mainMenu:while(true){
			System.out.println("=== ���Ǳ� �ùķ����� ===\n������� �����ϼ���.");
			for(int i=0;i<itemList.length;i++)
				System.out.print(i+1+". "+itemList[i]+" ");
			System.out.println("[0. ����ǰȮ��][�̿��� ��ȣ. ����]");
			selectMenu=Integer.parseInt(scan.nextLine());
			switch(selectMenu) {
			case 1:
			case 2:
			case 3:
				buyItem(selectMenu);
				break;
			case 0:
				reviewItem();
				break;
			default:
				break mainMenu;		
			}
		}
	}

	void reviewItem() {
		System.out.println("======����ǰ ���======\n������  : "+money+"��");
		for(int i=0;i<itemList.length;i++)
			System.out.println(itemList[i]+" : "+inventory[i]+"��");
	}
	
	void buyItem(int select) {
		int money=this.money, price=this.price[select-1];
		String itemList = this.itemList[select-1];
		if(money>=price) {
			this.money-=price;
			this.inventory[select-1]++;
			System.out.println(itemList+"�� �����߽��ϴ�.\n"+itemList+" +1\n������ -"+price);
		}
		else {
			System.out.println("���� �����ؼ� ���� �����߽��ϴ�.");
		}
	}
}