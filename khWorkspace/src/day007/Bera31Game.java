package day007;

class Bera31Game extends Bera31Data{
	void RunGame() {
		
		numberLocation=0;
		boolean trun = true;
		System.out.println(" <<  Game Start >>");
		gameMenu:while(true) {
			if(numberLocation==MAXCOUNT) {
				switch(Boolean.toString(trun)) {
				case "true":
					System.out.println("승리 하였습니다.");
					setGameCount(1,0);
					break gameMenu;
				case "false":
					System.out.println("패배 하였습니다.");
					setGameCount(0,1);
					break gameMenu;
				}
			}
			computer=((int)(Math.random()*3))+1;
			try {
				if(trun==true) {
					System.out.print("Input Number(1~3):");
					your=Integer.parseInt(scan.nextLine());
					if(your>3||your<=0) {
						System.out.println("숫자를 다시 입력해주세요.");
						continue;
					}
					else
						moveNumber(your);
				}
				else {
					System.out.println("<Computer Trun>");
					moveNumber(computer);
				}
				trun= !trun;
				continue;
			}catch(NumberFormatException e) {
				System.out.println("숫자를 다시 입력해주세요");
				continue;
			}
		}
	}
	
	void Bera31Menu(){
		while(true) {
			String[] menu = {"Game Start","Game Score","End Game"};
			int selectMenu;
			System.out.println("Baskin Robbins 31 Game\n");
			for(int i=0;i<menu.length;i++)
				System.out.println(i+1+". "+menu[i]);
			System.out.print(">");
			try {
				selectMenu=Integer.parseInt(scan.nextLine());
				switch(selectMenu) {
				case 1:
					RunGame();
					break;
				case 2:
					ViewCount();
					break;
				case 3:
					System.out.println("프로그램을 종료 합니다.");
					System.exit(0);
				default:
					System.out.println("보기내의 숫자를 입력해주세요.");
				}		
			}catch(NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}				
		}
	}
	
	void moveNumber(int count) {
		for(int i=0;i<count;i++) {
			if(numberLocation<31)
				System.out.println(++numberLocation+"!");				
		}
	}
	
	void ViewCount() {
		int[] score = getGameCount();
		System.out.println("<< 당신의 전적 >>\nW  i  n : "+score[0]+"\nL O S E : "+score[1]+"\nPLAYING : "+(score[0]+score[1]));
	}
}