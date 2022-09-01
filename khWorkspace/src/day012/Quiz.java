package day012;

import java.util.ArrayList;
import java.util.Scanner;

class Quiz {
	private ArrayList<Student> students = new ArrayList<Student>();
	Scanner scan = new Scanner(System.in);
	
	Quiz(){
		while(true) {
			System.out.println("<< �л� ���� ���α׷� >>");
			Check();
		}
	}
	
	void Check(){
		System.out.println("1. �ű� ���� �Է�\n2. �л� ��� ���\n3. ���α׷� ����");
		int selectMenu = IntCheck(scan.nextLine());
		switch(selectMenu) {
		case 1:
			InputStudent();
			break;
		case 2:
			ViewStudent();
			break;
		case 3:
			System.out.println("���α׷� ����");
			System.exit(0);
		default:
			System.out.println("����� ��ȣ�� �Է� ���ּ���.");
		}
	}
	
	void InputStudent() {
		String name;
		int kor,eng;
		System.out.print("�л� �̸��� �Է����ּ���. : ");
		name = scan.nextLine();
		System.out.print(name+"�л��� ���� ������ �Է����ּ���. : ");
		kor = IntCheck(scan.nextLine());
		System.out.print(name+"�л��� ���� ������ �Է����ּ���. : ");
		eng = IntCheck(scan.nextLine());
		this.students.add(new Student(name,kor,eng));
	}
	
	int IntCheck(String num) {
		while(true) {
			try {
				return Integer.parseInt(num);
			}catch(NumberFormatException e) {
				System.out.print("(�Է¿���)���ڸ� �Է����ּ��� : ");
				num = scan.nextLine();
			}
		}
	}
	
	void ViewStudent() {
		if(this.students.size()==0) {
			System.out.println("����� �����Ͱ� �����ϴ�.");
			return;
		}
		System.out.println("�̸�\t����\t����\t�հ�\t���");
		for(int i=0;i<this.students.size();i++) {
			System.out.println(this.students.get(i).getName()+"\t"+this.students.get(i).getKor()+"\t"+this.students.get(i).getEng()+"\t"+this.students.get(i).getSum()+"\t"+this.students.get(i).getAvg());
		}
	}
}