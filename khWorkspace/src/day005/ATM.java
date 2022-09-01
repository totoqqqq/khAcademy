package day005;

import java.util.Scanner;

class ATM {
	private int money;//중요데이터로 직접적인 외부에서 변수수정을 제한.
	Scanner scan = new Scanner(System.in);
	String[] atmMenu = {"잔액조회","입금하기","출금하기","종료하기"};
	ATM(){
		int selectMenu;
		this.money=0;
		mainMenu:while(true) {
			System.out.println("***ATM 시뮬레이터***");
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
				System.out.println("프로그램을 종료합니다.");
				break mainMenu;
			default:
				System.out.println("선택을 다시해주세요.");
				break;
			}
		}
	}
	
	void checkBalance() {//조회하기 구현부.
		int money=this.money;
		System.out.println("현재 보유잔액은 "+money+"원 입니다.");
	}
	
	void deposit() {//입금하기 구현부.
		int money;
		while(true) {
			System.out.print("입금할 금액을 입력해주세요. (0원 입력시 취소):");
			money=Integer.parseInt(scan.nextLine());
			if(money<1) {
				if(money==0) {
					System.out.println("입금을 취소하셨습니다.");
					break;
				}
				else
					System.out.println("1원 이상 입금하셔야 됩니다.");
			}
			else {
				this.money+=money;
				System.out.println(money+"원이 입금되었습니다.");
				break;
			}
		}
	}
	
	void withdraw() {//출금하기 구현부.
		int money;
		while(true) {
			System.out.print("출금할 금액을 입력해주세요. (0원 입력시 취소):");
			money=Integer.parseInt(scan.nextLine());
			if(money<1) {
				if(money==0) {
					System.out.println("출금을 취소하셨습니다.");
					break;
				}
				else
					System.out.println("1원 이상 출금하셔야 됩니다.");
			}
			else {
				if(this.money>=money) {
					this.money-=money;
					System.out.println(money+"원이 출금되었습니다.");
					break;
				}
				else
					System.out.println("계좌에 소지하신 금액이 부족하여 출금이 취소되었습니다.");
			}
		}
	}
}