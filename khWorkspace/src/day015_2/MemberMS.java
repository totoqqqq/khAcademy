package day015_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class MemberMS {
	private Scanner scan=new Scanner(System.in);
	void run(){
		int selectMenu;
		while(true) {
			System.out.print("<< ȸ�� ���� �ý��� >>\n1. �ű� ȸ�� ���\n2. ȸ�� ���� ���\n>>");
			selectMenu=Integer.parseInt(scan.nextLine());
			switch(selectMenu){
				case 1:
					createMember();
					break;
				case 2:
					readMember();
					break;
			}
		}
	}
	void createMember(){
		int id, point, bonus;
		String name;
		while(true) {
			System.out.print("ȸ�� ��ȣ�� �Է����ּ���. : ");
			id=Integer.parseInt(scan.nextLine());
			System.out.print("ȸ�� �̸��� �Է����ּ���. : ");
			name=scan.nextLine();
			System.out.print("ȸ�� ����Ʈ�� �Է����ּ���. : ");
			point=Integer.parseInt(scan.nextLine());
			System.out.print("ȸ�� ����� �Է����ּ���. (0-Bronze, 1-Silver, 2-Gold, 3-VIP, etc-unKnown: ");
			bonus=Integer.parseInt(scan.nextLine());
			if(true) {
				new MemberEntity().addMemberDB(new MemberDTO(id,name,point,bonus));
				return;
			}
		}
	}
	
	void readMember() {
		ArrayList<MemberDTO> member = new MemberEntity().getMemberDB();
		List<String> viewMember = new ArrayList<String>();
		for(MemberDTO dto:member) {
			viewMember.add(dto.getId()+"\t"+dto.getName()+"\t"+dto.getPoint()+"\t"+(dto.getBonus()==0?"Bronze":dto.getBonus()==1?"Silver":dto.getBonus()==2?"Gold":dto.getBonus()==3?"VIP":"Unknown"));
			viewMember.sort(Comparator.naturalOrder());
		}
		System.out.println("ȸ�� ��ȣ\t�̸�\t����Ʈ\tȸ�����");
		for(String str:viewMember) {
			System.out.println(str);
		}
	}
}