package day004;

import java.io.IOException;

class InputExam02 {
	InputExam02() throws IOException{
		for(int i=0;i++<2;) {
			System.out.print("한 글자를 입력하세요.");
			int input=System.in.read();
			System.out.println("입력하신 문자는 " + input + " 입니다.");
			System.in.skip(2);
		}
	}	
}