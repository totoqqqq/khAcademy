package day004;

import java.text.DecimalFormat;
import java.util.Scanner;

class CommaFormatExam {
	CommaFormatExam(){
		DecimalFormat comma = new DecimalFormat("###,###,###");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputOne;
		System.out.print("데이터를 입력하세요.(1) : ");
		inputOne=scan.nextInt();
		System.out.println("입력받은 데이터는 "+comma.format(inputOne));
	}
}