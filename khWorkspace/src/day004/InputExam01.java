package day004;
import java.io.IOException;
import java.util.Scanner;

class InputExam01 {
	InputExam01() throws IOException{
		System.in.read();//system.in.read�� ���°� ������ ��... throws IOException ���ָ� �ɵ�... �ƿ� scan���� ��ü��..
		@SuppressWarnings("resource")//Scanner�� ���ҽ� ��� ��� ����ó��. 
		Scanner scan = new Scanner(System.in);
		System.out.print("���ڿ��� �Է��ϼ���. : ");
		String inputScan = scan.nextLine();
		System.out.println("�Է¹��� ���ڿ��� : "+inputScan);
	}
}
