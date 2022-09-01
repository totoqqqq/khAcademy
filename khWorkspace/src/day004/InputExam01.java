package day004;
import java.io.IOException;
import java.util.Scanner;

class InputExam01 {
	InputExam01() throws IOException{
		System.in.read();//system.in.read를 쓰는건 간만에 봄... throws IOException 해주면 될듯... 아에 scan으로 대체를..
		@SuppressWarnings("resource")//Scanner의 리소스 노랑 경고 무시처리. 
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. : ");
		String inputScan = scan.nextLine();
		System.out.println("입력받은 문자열은 : "+inputScan);
	}
}
