package day005;

import java.util.Scanner;

public class VendingMachine {
	private String[] itemList = {"콜라","사이다","매실차"};
	private int[] price = {1000,800,1500};
	private int[] inventory = {0,0,0};
	private int money;
	Scanner scan = new Scanner(System.in);
	VendingMachine(){
		int selectMenu;
		this.money=3000;
		mainMenu:while(true){
			System.out.println("=== 자판기 시뮬레이터 ===\n음료수를 선택하세요.");
			for(int i=0;i<itemList.length;i++)
				System.out.print(i+1+". "+itemList[i]+" ");
			System.out.println("[0. 소지품확인][이외의 번호. 종료]");
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
		System.out.println("======소지품 목록======\n소지금  : "+money+"원");
		for(int i=0;i<itemList.length;i++)
			System.out.println(itemList[i]+" : "+inventory[i]+"개");
	}
	
	void buyItem(int select) {
		int money=this.money, price=this.price[select-1];
		String itemList = this.itemList[select-1];
		if(money>=price) {
			this.money-=price;
			this.inventory[select-1]++;
			System.out.println(itemList+"를 구매했습니다.\n"+itemList+" +1\n소지금 -"+price);
		}
		else {
			System.out.println("돈이 부족해서 구매 실패했습니다.");
		}
	}
}