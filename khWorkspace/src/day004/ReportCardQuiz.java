package day004;

import java.util.Scanner;

class ReportCardQuiz {
	ReportCardQuiz(){
		String[] subjectName = {"국 어","영 어","수 학"};//과목명 저장 string 배열
		int[] subjectScore = new int[3];//과목 점수 저장 int 배열
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);		
		System.out.print("학생의 이름을 입력해주세요 : ");
		String name = scan.nextLine(); //이름 input
		for(int i=0;i<3;i++) {
			System.out.print(subjectName[i]+"의 점수를 입력해주세요 : ");
			subjectScore[i]=Integer.parseInt(scan.nextLine()); // 과목 점수 input
		}
		System.out.println("===============\n이 름 : "+name+"\n===============");
		for(int i=0;i<3;i++)
			System.out.println(subjectName[i]+" : "+subjectScore[i]); // 과목명, 점수 출력
		System.out.println("===============\n합 계 : "+(subjectScore[0]+subjectScore[1]+subjectScore[2])); //합계 출력
		System.out.printf("평 균 : %.2f\n===============",((float)(subjectScore[0]+subjectScore[1]+subjectScore[2])/3)); //평균 출력
	}
}