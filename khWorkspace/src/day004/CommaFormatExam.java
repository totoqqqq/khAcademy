package day004;

import java.text.DecimalFormat;
import java.util.Scanner;

class CommaFormatExam {
	CommaFormatExam(){
		DecimalFormat comma = new DecimalFormat("###,###,###");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputOne;
		System.out.print("�����͸� �Է��ϼ���.(1) : ");
		inputOne=scan.nextInt();
		System.out.println("�Է¹��� �����ʹ� "+comma.format(inputOne));
	}
}