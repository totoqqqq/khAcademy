package day017;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		/*����Ŭ ����� ���� ����(���� 1ȸ ����)*/
//		
//		 Connect db = new Connect(); try { db.
//		 pstmt("create table schoolexam(id char(10) not null primary key,name varchar2(14) not null,kor number(3) not null,eng number(3) not null,math number(3) not null,days varchar2(10) not null)"
//		 ).execute(); db.close();
//		 
//		 } catch (SQLException e) { e.printStackTrace(); }
		 
		String selectMenu;
		main:while(true) {
			System.out.println("<<�л������ý���>>\n1. �ű� ���� �Է�\n2. �л� ��� ���\n3. �л� ���� ����\n4. �л� ���� ����");
			selectMenu=scan.nextLine();
			switch(selectMenu) {
			case "1":
				System.out.println("�ű� �й��� �Է��ϼ���.");
				String id = scan.nextLine();
				System.out.println("�л� �̸��� �Է��ϼ���.");
				String name = scan.nextLine();
				System.out.println(name+ " �л� ���� ������ �Է��ϼ���.");
				int kor = Integer.parseInt(scan.nextLine());
				System.out.println(name+ " �л� ���� ������ �Է��ϼ���.");
				int eng = Integer.parseInt(scan.nextLine());
				System.out.println(name+ " �л� ���� ������ �Է��ϼ���.");
				int math = Integer.parseInt(scan.nextLine());
				new Controller().createInput(id,name,kor,eng,math);
				break;
			case "2":
				String selectType;
				type:while(true) {
					System.out.print("�˻��� ������ �Է����ּ���.(�л���ȣ,�̸�,����,����,����(���ش� ������� Ư�� ���� �̻�); ���Է½� ��ü �˻�) : ");
					selectType=scan.nextLine();
					switch(selectType) {
					case "�л���ȣ":
						selectType="id";
						break type;
					case "�̸�":
						selectType="name";
						break type;
					case "����":
						selectType="kor";
						break type;
					case "����":
						selectType="eng";
						break type;
					case "����":
						selectType="math";
						break type;
					case"":
						new StudentDAO().readStudent();
						continue main;
					default:
						System.out.println("�ٽ� �Է����ּ���.");
					}
				}
				String searchStr;
				System.out.println("�˻��� ���� �Է����ּ���.");
				searchStr=scan.nextLine();
				new Controller().readInput(selectType, searchStr);
				break;
			case "3":
				System.out.println("������ �л��� �й� Ȥ�� �̸��� �Է����ּ���.");
				String updateStr=scan.nextLine();
				new Controller().updateInput(updateStr);
				break;
			case "4":
				System.out.println("������ �л��� �й� Ȥ�� �̸��� �Է����ּ���.");
				String dedateStr=scan.nextLine();
				new Controller().deleteInput(dedateStr);
				break;
			default:
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}
}