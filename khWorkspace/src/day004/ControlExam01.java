package day004;

import java.util.Scanner;

class ControlExam01 {
	ControlExam01(){
		String[][] fruit = {{"���","����","����"},{"Apple","Mango","Grape"}};
		int select;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("����� �����ϴ� ������ �����ϼ���.");
		for(int i=0;i<fruit[0].length;i++)
			System.out.println(i+1+". "+fruit[0][i]);
		while(true){
			try {
				select=Integer.parseInt(scan.nextLine());
				if(select>fruit[0].length||select<=0)
					System.out.println("������ ���ڸ� �Է����ּ���.");
				else
					break;
			}catch(NumberFormatException e){
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}
		}
		System.out.println(fruit[0][select-1]+"�� ����� "+fruit[1][select-1]+" �Դϴ�.");
	}
}