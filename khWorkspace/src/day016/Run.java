package day016;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		/*����Ŭ ����� ���� ����(���� 1ȸ ����)*/
//		Connect db = new Connect();
//		try {
//			db.pstmt("create table exam(id number(4) not null unique,name varchar2(14) not null,phone char(11) not null primary key,point number(5) not null,bonus number(4) not null,levels number(2) not null)").execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		String select;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("===================\nȸ�� ���� �ý���\n===================\n1. ȸ�� ����\n2. ȸ�� ��ȸ\n3. ȸ�� ���� ����\n4. ȸ�� ����\n5. ���α׷� ����\n>>");
			select=scan.nextLine();
			main:switch(select) {
			case "1":
				new MemberCreate();
				break;
			case "2":
				String type;
				type:while(true) {
					System.out.print("�˻��� ����(ȸ����ȣ,�̸�,�޴���ȭ,���)�� �־��ּ���.(�Է�X ���� : ��ü��ȸ) : ");
					type=scan.nextLine();
					switch(type) {
					case "ȸ����ȣ":
					case "�̸�":
					case "�޴���ȭ":
						break type;
					case "���":
						System.out.print("(Bronze, Silver, Gold, VIP, Unknows �� �˻����ּ���-�̿� �Է� Unknows �˻�)");
						break type;
					case "":
						new MemberRead();
						break main;
					default:
						System.out.println("������ �ٽ� �Է����ּ���.");
						break;
					}
				}
				System.out.println("�˻��� "+type+"��(��) �Է����ּ���.");
				type=type.equals("ȸ����ȣ")?"id":type.equals("�̸�")?"name":type.equals("�޴���ȭ")?"phone":"levels";
				String search = scan.nextLine();
				if(type.equals("levels"))
					search=search.equals("Bronze")?"0":search.equals("Silver")?"1":search.equals("Gold")?"2":search.equals("VIP")?"3":"4";
				new MemberRead(type,search);
				break;
			case "3":
				String updateId;
				System.out.println("���� �� ȸ����ȣ�� �Է��ϼ���.");
				updateId=scan.nextLine();
				new MemberUpdate(updateId);
				break;
			case "4":
				String deleteId;
				System.out.println("���� �� ȸ����ȣ�� �Է��ϼ���.");
				deleteId=scan.nextLine();
				new MemberDelete(deleteId);
				break;
			case "5":
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("[�Է� ����] Ȯ�� �� �ٽ� �Է����ּ���.");
			}
		}
	}
}