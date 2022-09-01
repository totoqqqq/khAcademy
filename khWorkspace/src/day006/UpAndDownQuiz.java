package day006;

import java.util.Scanner;

class UpAndDownQuiz {
	private int score, count, win, minTime;
	private final int GAMEMIN=1,GAMEMAX=99;
	Scanner scan = new Scanner(System.in);
	
	UpAndDownQuiz(){ //메인 메뉴
		int modChoice;
		score=0;
		count=0;
		win=0;
		minTime=20;
		String[] gameMenu= {"게임시작","점수확인","게임종료"};
		mainMenu:while(true) {
			System.out.print("== Up & Down Game ==\n");
			for(int i=0;i<gameMenu.length;i++)
				System.out.println(i+1+". "+gameMenu[i]);
			try {
				modChoice=Integer.parseInt(scan.nextLine());
				switch(modChoice) {
					case 1:
						UpAndDownGame();
						break;
					case 2:
						ScoreView();
						break;
					case 3:
						break mainMenu;
					default:
						System.out.println("번호를 잘못 입력 하셨습니다.");
						continue mainMenu;
				}
			}catch(NumberFormatException e) {
				System.out.println("번호를 잘못 입력 하셨습니다.");
				continue;
			}
		}
		System.out.println("게임을 종료합니다.");
	}
	
	void UpAndDownGame() {//게임 실행부
		int userSay, sayUp=GAMEMIN, sayDown=GAMEMAX, computer=((int)(Math.random()*99+1)),score=100,minTime;
		System.out.println("<< Game Start >>");
		while(true) {
			try {
				if(score==0) {
					System.out.println("20회 내에 맞추기를 실패하여 정답 공개 합니다. : "+computer);
					this.count++;
					break;
				}
				System.out.println(sayUp+" ~ "+sayDown+" 사이 숫자를 말해주세요.\ninput Number : ");
				userSay=Integer.parseInt(scan.nextLine());
				if(userSay>sayDown||userSay<sayUp) {
					System.out.println(sayUp+" 이상 "+sayDown+"이하로 다시 입력 해주세요.");
					continue;
				}
				else {
					if(userSay==computer) {
						System.out.println("정답입니다!");
						this.score+=score;
						minTime=(105-score)/5;
						if(this.minTime>minTime)
							this.minTime=minTime;
						this.count++;
						this.win++;
						break;
					}
					else if(userSay>computer) {
						score-=5;
						sayDown=userSay-1;
						System.out.println(userSay+"보다 아래가 정답입니다.");
					}
					else {
						score-=5;
						sayUp=userSay+1;
						System.out.println(userSay+"보다 위가 정답입니다.");
					}
				}
			}catch(NumberFormatException e){
				System.out.println("범위내의 숫자를 다시 입력 해주세요.");
				continue;
			}
		}
	}
	
	void ScoreView() { //점수 확인부
		int score=this.score, count=this.count, win=this.win, minTime=this.minTime;
		System.out.println("현재 획득한 점수는 "+score+"\n게임에 참가한 횟수는 "+count+"입니다.(승리 수 : "+win+" 패배 수 : "+(count-win)+")\n최단 질문으로 성공한 질문 수: "+minTime+"회");
	}
}