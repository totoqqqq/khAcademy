package day004;

import java.util.Scanner;

class ControlHomeQuiz {
	ControlHomeQuiz(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String[] thinking = {"투시","비행","시간여행","투명인간","변신","독심술","예언능력"};
		int thinkSelect;
		System.out.println("당신이 만약 초능력을 하나 갖게 된다면 어떤 것을 가지고 싶나요?");
		for(int i=0;i<thinking.length;i++)
			System.out.println(i+1+" 번 : "+thinking[i]);
		while(true) { // 오선택 검증 부분
			try {
				thinkSelect=Integer.parseInt(scan.nextLine());
				if(thinkSelect<=0 || thinkSelect>thinking.length)
					System.out.println("번호 내의 숫자만 입력해주세요.");
				else
					break;
			}catch(NumberFormatException e){
				System.out.println("번호 내의 숫자만 입력해주세요.");
			}
		}
		System.out.print(thinkSelect+". "); // 선택 결과 해석 switch 문
		switch(thinkSelect){
			case 1:
				System.out.println("문제 분석형 : 어떤 문제든 철저하게 파헤치고 분석하는 성격을 가지셨네요. \n다른 사람들이 알아채지 못하는 문제점도 척척 발견합니다. 내게 어울리는 분야는 정치학, 수학, 의학, 물리학 등이 있어요.");
				break;
			case 2:
				System.out.println("대범한 자유형 : 작은 것은 마음에 두지 않는 대범한 성격의 소유자십니다. \n모험과 자유를 즐기고 싶은 마음이 강하세요. 참신한 아이디어가 툭툭 튀어나오는 창의적인 일이 맞아요. 어울리는 분야는 광고학, 건축학 등입니다.");
				break;
			case 3:
				System.out.println("호기심 많은 유형 : 다방면에 호기심이 많은 당신은 원인 분석하는 것을 좋아합니다. \n이 일이 일어난 원인, 왜 이렇게 된 건지 등등의 질문들이 언제나 머리속에 가득 차 있어요. 어울리는 직업 분야로는 과학연구, 역사학 등이 있습니다. ");
				break;
			case 4:
				System.out.println("뛰어난 관찰자형 : 현상을 판단하는데 날카로운 면이 있어요. \n상환판단 능력이 뛰어나 원인과 결과에 대해 정확히 알고 있습니다. 특히 어떤 이야기를 만들거나 추리해 내는데 탁월한 능력이 있어요. 어울리는 직업 분야로는 작가, 예술가, 탐정 등이 있습니다. ");
				break;
			case 5:
				System.out.println("사교적인 유형 : 뛰어난 사교술로 여러사람들에게 인기가 많은 분이세요. \n나를 좋아하는 사람이 늘 주위에 있습니다. 사람들이 많은 곳에 서서 이야기하거나 공연하는 것을 매우 좋아해요. 어울리는 분야는 연예계 분야인 가수, 배우, 개그맨 등이 있습니다. ");
				break;
			case 6:
				System.out.println("독심술가 유형 : 다른 사람들의 마음을 꿰뚫어 보는 능력이 있어요. \n다른 사람의 감정을 잘 읽고, 지금 무슨 생각을 하는지도 척척 알아 맞힙니다. 이러한 당신과 어울리는 분야는 심리학, 상담 등이 있어요. ");
				break;
			case 7:
				System.out.println("끝을 보는 인내형 : 인내심이 매우 강하시군요. 어떤 일을 하든지 끝을 보고 마는 성격입니다. \n당신은 마음에 들때까지 포기하지 않고 계속하는 끈기가 있으세요. 이러한 당신에게는 탐험가나 발명가, 과학자 등이 매우 어울리는 분야입니다. ");
				break;
		}
	}
}