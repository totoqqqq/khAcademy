package day012;

import java.util.ArrayList;
import java.util.Scanner;

class Quiz {
	private ArrayList<Student> students = new ArrayList<Student>();
	Scanner scan = new Scanner(System.in);
	
	Quiz(){
		while(true) {
			System.out.println("<< 학생 관리 프로그램 >>");
			Check();
		}
	}
	
	void Check(){
		System.out.println("1. 신규 정보 입력\n2. 학생 목록 출력\n3. 프로그램 종료");
		int selectMenu = IntCheck(scan.nextLine());
		switch(selectMenu) {
		case 1:
			InputStudent();
			break;
		case 2:
			ViewStudent();
			break;
		case 3:
			System.out.println("프로그램 종료");
			System.exit(0);
		default:
			System.out.println("목록의 번호만 입력 해주세요.");
		}
	}
	
	void InputStudent() {
		String name;
		int kor,eng;
		System.out.print("학생 이름을 입력해주세요. : ");
		name = scan.nextLine();
		System.out.print(name+"학생의 국어 점수를 입력해주세요. : ");
		kor = IntCheck(scan.nextLine());
		System.out.print(name+"학생의 영어 점수를 입력해주세요. : ");
		eng = IntCheck(scan.nextLine());
		this.students.add(new Student(name,kor,eng));
	}
	
	int IntCheck(String num) {
		while(true) {
			try {
				return Integer.parseInt(num);
			}catch(NumberFormatException e) {
				System.out.print("(입력오류)숫자를 입력해주세요 : ");
				num = scan.nextLine();
			}
		}
	}
	
	void ViewStudent() {
		if(this.students.size()==0) {
			System.out.println("저장된 데이터가 없습니다.");
			return;
		}
		System.out.println("이름\t국어\t영어\t합계\t평균");
		for(int i=0;i<this.students.size();i++) {
			System.out.println(this.students.get(i).getName()+"\t"+this.students.get(i).getKor()+"\t"+this.students.get(i).getEng()+"\t"+this.students.get(i).getSum()+"\t"+this.students.get(i).getAvg());
		}
	}
}