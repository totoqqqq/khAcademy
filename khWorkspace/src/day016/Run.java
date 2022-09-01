package day016;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		/*오라클 저장소 생성 구문(최초 1회 실행)*/
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
			System.out.print("===================\n회원 관리 시스템\n===================\n1. 회원 가입\n2. 회원 조회\n3. 회원 정보 수정\n4. 회원 삭제\n5. 프로그램 종료\n>>");
			select=scan.nextLine();
			main:switch(select) {
			case "1":
				new MemberCreate();
				break;
			case "2":
				String type;
				type:while(true) {
					System.out.print("검색할 종류(회원번호,이름,휴대전화,등급)를 넣어주세요.(입력X 엔터 : 전체조회) : ");
					type=scan.nextLine();
					switch(type) {
					case "회원번호":
					case "이름":
					case "휴대전화":
						break type;
					case "등급":
						System.out.print("(Bronze, Silver, Gold, VIP, Unknows 중 검색해주세요-이외 입력 Unknows 검색)");
						break type;
					case "":
						new MemberRead();
						break main;
					default:
						System.out.println("종류로 다시 입력해주세요.");
						break;
					}
				}
				System.out.println("검색할 "+type+"을(를) 입력해주세요.");
				type=type.equals("회원번호")?"id":type.equals("이름")?"name":type.equals("휴대전화")?"phone":"levels";
				String search = scan.nextLine();
				if(type.equals("levels"))
					search=search.equals("Bronze")?"0":search.equals("Silver")?"1":search.equals("Gold")?"2":search.equals("VIP")?"3":"4";
				new MemberRead(type,search);
				break;
			case "3":
				String updateId;
				System.out.println("수정 할 회원번호를 입력하세요.");
				updateId=scan.nextLine();
				new MemberUpdate(updateId);
				break;
			case "4":
				String deleteId;
				System.out.println("삭제 할 회원번호를 입력하세요.");
				deleteId=scan.nextLine();
				new MemberDelete(deleteId);
				break;
			case "5":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("[입력 오류] 확인 후 다시 입력해주세요.");
			}
		}
	}
}