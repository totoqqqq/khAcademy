package day004;

import java.util.Scanner;//Scanner import.

class InputExam03 {
	InputExam03(){
		@SuppressWarnings("resource")//Scanner �ν��Ͻ� scan�� resource ��� ���ý�Ű��
		Scanner scan = new Scanner(System.in);//Scanner Ŭ������ �ν��Ͻ� scan ����.
		String inputString;
		for(int i=0;i++<2;) {
			System.out.print("���ڿ��� �Է����ּ���. : ");
			inputString=scan.nextLine();
			System.out.println("�Է¹��� �� : "+inputString);
		}
	}
}