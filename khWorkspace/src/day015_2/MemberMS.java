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
			System.out.print("<< 회원 관리 시스템 >>\n1. 신규 회원 등록\n2. 회원 정보 출력\n>>");
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
			System.out.print("회원 번호를 입력해주세요. : ");
			id=Integer.parseInt(scan.nextLine());
			System.out.print("회원 이름를 입력해주세요. : ");
			name=scan.nextLine();
			System.out.print("회원 포인트를 입력해주세요. : ");
			point=Integer.parseInt(scan.nextLine());
			System.out.print("회원 등급을 입력해주세요. (0-Bronze, 1-Silver, 2-Gold, 3-VIP, etc-unKnown: ");
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
		System.out.println("회원 번호\t이름\t포인트\t회원등급");
		for(String str:viewMember) {
			System.out.println(str);
		}
	}
}