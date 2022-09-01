package day006;

import java.util.Scanner;

class UpAndDownQuiz {
	private int score, count, win, minTime;
	private final int GAMEMIN=1,GAMEMAX=99;
	Scanner scan = new Scanner(System.in);
	
	UpAndDownQuiz(){ //���� �޴�
		int modChoice;
		score=0;
		count=0;
		win=0;
		minTime=20;
		String[] gameMenu= {"���ӽ���","����Ȯ��","��������"};
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
						System.out.println("��ȣ�� �߸� �Է� �ϼ̽��ϴ�.");
						continue mainMenu;
				}
			}catch(NumberFormatException e) {
				System.out.println("��ȣ�� �߸� �Է� �ϼ̽��ϴ�.");
				continue;
			}
		}
		System.out.println("������ �����մϴ�.");
	}
	
	void UpAndDownGame() {//���� �����
		int userSay, sayUp=GAMEMIN, sayDown=GAMEMAX, computer=((int)(Math.random()*99+1)),score=100,minTime;
		System.out.println("<< Game Start >>");
		while(true) {
			try {
				if(score==0) {
					System.out.println("20ȸ ���� ���߱⸦ �����Ͽ� ���� ���� �մϴ�. : "+computer);
					this.count++;
					break;
				}
				System.out.println(sayUp+" ~ "+sayDown+" ���� ���ڸ� �����ּ���.\ninput Number : ");
				userSay=Integer.parseInt(scan.nextLine());
				if(userSay>sayDown||userSay<sayUp) {
					System.out.println(sayUp+" �̻� "+sayDown+"���Ϸ� �ٽ� �Է� ���ּ���.");
					continue;
				}
				else {
					if(userSay==computer) {
						System.out.println("�����Դϴ�!");
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
						System.out.println(userSay+"���� �Ʒ��� �����Դϴ�.");
					}
					else {
						score-=5;
						sayUp=userSay+1;
						System.out.println(userSay+"���� ���� �����Դϴ�.");
					}
				}
			}catch(NumberFormatException e){
				System.out.println("�������� ���ڸ� �ٽ� �Է� ���ּ���.");
				continue;
			}
		}
	}
	
	void ScoreView() { //���� Ȯ�κ�
		int score=this.score, count=this.count, win=this.win, minTime=this.minTime;
		System.out.println("���� ȹ���� ������ "+score+"\n���ӿ� ������ Ƚ���� "+count+"�Դϴ�.(�¸� �� : "+win+" �й� �� : "+(count-win)+")\n�ִ� �������� ������ ���� ��: "+minTime+"ȸ");
	}
}