package day004;

import java.util.Scanner;

class InputQuiz01 {
	InputQuiz01(){
		String[] infoData = new String[2];
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.print("<< �湮�� >>\n�̸��� ����ó�� �ۼ����ּ���.\n�̸� : ");
		infoData[0]=scan.nextLine();
		System.out.print("����ó(�޴��� ��ȣ) : ");
		infoData[1]=scan.nextLine();
		System.out.println("====================\n���� "+infoData[0]+" �Դϴ�.\n"+infoData[1]+" �� ���� �ּ���.");
	}
}
