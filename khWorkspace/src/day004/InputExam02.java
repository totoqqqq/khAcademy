package day004;

import java.io.IOException;

class InputExam02 {
	InputExam02() throws IOException{
		for(int i=0;i++<2;) {
			System.out.print("�� ���ڸ� �Է��ϼ���.");
			int input=System.in.read();
			System.out.println("�Է��Ͻ� ���ڴ� " + input + " �Դϴ�.");
			System.in.skip(2);
		}
	}	
}