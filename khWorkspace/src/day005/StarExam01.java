package day005;

import java.util.Scanner;

class StarExam01 {
	StarExam01(){
		int inputSize;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.print("�ﰢ�� ���̸� �Է����ּ���.");
		inputSize=Integer.parseInt(scan.nextLine());
		//��� ��ü �Է�
//		for(int i=0;i<inputSize;i++) {
//			for(int j=0;j<inputSize;j++)
//				System.out.print("��");	
//			System.out.println("");
//		}
		//1. 7��
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(i>=j)
					System.out.print("��");
			}
			System.out.println("");
		}
		System.out.println("");
		//2. 10��
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(j-i>=0)
					System.out.print("��");
			}
			System.out.println("");
		}
		System.out.println("");
		//3. 1��
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(i>j)
					System.out.print("��");
				else
					System.out.print("��");
			}
			System.out.println("");
		}
		System.out.println("");
		//4. 4��
		for(int i=0;i<inputSize;i++) {
			for(int j=0;j<inputSize;j++) {
				if(inputSize-1>j+i)
					System.out.print("��");
				else
					System.out.print("��");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
