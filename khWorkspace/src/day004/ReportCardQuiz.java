package day004;

import java.util.Scanner;

class ReportCardQuiz {
	ReportCardQuiz(){
		String[] subjectName = {"�� ��","�� ��","�� ��"};//����� ���� string �迭
		int[] subjectScore = new int[3];//���� ���� ���� int �迭
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);		
		System.out.print("�л��� �̸��� �Է����ּ��� : ");
		String name = scan.nextLine(); //�̸� input
		for(int i=0;i<3;i++) {
			System.out.print(subjectName[i]+"�� ������ �Է����ּ��� : ");
			subjectScore[i]=Integer.parseInt(scan.nextLine()); // ���� ���� input
		}
		System.out.println("===============\n�� �� : "+name+"\n===============");
		for(int i=0;i<3;i++)
			System.out.println(subjectName[i]+" : "+subjectScore[i]); // �����, ���� ���
		System.out.println("===============\n�� �� : "+(subjectScore[0]+subjectScore[1]+subjectScore[2])); //�հ� ���
		System.out.printf("�� �� : %.2f\n===============",((float)(subjectScore[0]+subjectScore[1]+subjectScore[2])/3)); //��� ���
	}
}