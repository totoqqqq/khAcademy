package day007_test01;

import java.util.Scanner;

class UmaGame {
	private int money;
	Scanner scan = new Scanner(System.in);
	UmaGame(){
		int selectMenu;
		this.money=0;
		String[] gameMenu = {"게임시작","잔액충전","잔액조회","게임종료"};
		while(true){
			line();
			System.out.println("<<<경마 게임에 오신걸 환영합니다.>>>");
			for(int i=0;i<4;i++)
				System.out.println(i+1+". "+gameMenu[i]);
			try {
				System.out.print("메뉴를 선택해주세요.\n>>");
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
					System.out.println("프로그램을 종료 합니다.");
					System.exit(0);
				default:
					System.out.println("번호를 제대로 입력해주세요.");
				}
			}catch(NumberFormatException e){
				System.out.println("번호를 제대로 입력해주세요.");
			}
		}
	}
	
	void StartUmaGame() {
		while(true) {
			int money=this.money, selectUma, inputMoney, winUma=(int)(Math.random()*3)+1;
			line();
			System.out.println("게임을 시작합니다. (현재 보유 금액은 "+money+"원 입니다.)");
			if(money==0) {
				System.out.println("보유금액이 없으셔서 자동 종료 합니다. 충전 해주세요.");
				break;
			}
			System.out.print("1. 우승경력이 많지만 은퇴를 앞둔 말\n2. 이번 달 성적이 제일 좋은 말\n3. 최근 떠오르는 신예의 말\n배팅 하고 싶은 말을 선택해주세요.>>");
			try {
				selectUma=Integer.parseInt(scan.nextLine());
				if(selectUma<=0||selectUma>3) {
					System.out.println("말 번호를 제대로 골라주세요.");
					continue;
				}
				while(true) {
					System.out.print("얼마를 배팅 하시겠습까?(최대한도"+money+"원):");
					inputMoney=Integer.parseInt(scan.nextLine());
					line();
					if(money<inputMoney)
						System.out.println("잔액이 부족합니다.");
					else if(inputMoney<=0)
						System.out.println("1원 이상 배팅해야 됩니다.");
					else {
						this.money-=inputMoney;
						break;
					}
				}
				if(selectUma==winUma) {
					this.money+=(inputMoney*2);
					System.out.println(selectUma+"번 말이 우승하였습니다.\n배팅에 성공하였습니다..!\n배팅한 금액의 2배인 "+inputMoney*2+"원을 획득하였습니다.");
					break;
				}
				else {
					System.out.println(winUma+"번 말이 우승하였습니다.\n배팅에 실패하였습니다...^^\n배팅한 금액인 "+inputMoney+"원을 모두 잃으셨습니다.");
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자를 제대로 입력해주세요.");
			}
		}
	}
	
	void InputUmaCash() {
		int money=this.money, inputmoney;
		while(true) {
			try {
				System.out.print("얼마를 충전하시겠습까 ?");
				inputmoney=Integer.parseInt(scan.nextLine());
				if(money < -inputmoney)
					System.out.println("잔액이 부족하여 출금 불가합니다.");
				else if(inputmoney<=0){
					System.out.println(inputmoney+"원 출금 되었습니다.");
					this.money+=inputmoney;
					break;
				}
				else {
					System.out.println(inputmoney+"원이 충전되었습니다.");
					this.money+=inputmoney;
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println("제대로 된 금액을 입력해주세요.");
			}
		}
	}
	
	void ViewUmaCash() {
		int money=this.money;
		System.out.println("현재 잔액은 :"+money+"원 입니다.");
	}
	

	void line() {
		for(int i=0;i<90;i++)
			System.out.print("-");
		System.out.println("");
	}
}