package day017;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		/*오라클 저장소 생성 구문(최초 1회 실행)*/
//		
//		 Connect db = new Connect(); try { db.
//		 pstmt("create table schoolexam(id char(10) not null primary key,name varchar2(14) not null,kor number(3) not null,eng number(3) not null,math number(3) not null,days varchar2(10) not null)"
//		 ).execute(); db.close();
//		 
//		 } catch (SQLException e) { e.printStackTrace(); }
		 
		String selectMenu;
		main:while(true) {
			System.out.println("<<학생관리시스템>>\n1. 신규 정보 입력\n2. 학생 목록 출력\n3. 학생 정보 수정\n4. 학생 정보 삭제");
			selectMenu=scan.nextLine();
			switch(selectMenu) {
			case "1":
				System.out.println("신규 학번을 입력하세요.");
				String id = scan.nextLine();
				System.out.println("학생 이름을 입력하세요.");
				String name = scan.nextLine();
				System.out.println(name+ " 학생 국어 성적을 입력하세요.");
				int kor = Integer.parseInt(scan.nextLine());
				System.out.println(name+ " 학생 영어 성적을 입력하세요.");
				int eng = Integer.parseInt(scan.nextLine());
				System.out.println(name+ " 학생 수학 성적을 입력하세요.");
				int math = Integer.parseInt(scan.nextLine());
				new Controller().createInput(id,name,kor,eng,math);
				break;
			case "2":
				String selectType;
				type:while(true) {
					System.out.print("검색할 종류를 입력해주세요.(학생번호,이름,국어,영어,수학(※해당 과목들의 특정 점수 이상); 미입력시 전체 검색) : ");
					selectType=scan.nextLine();
					switch(selectType) {
					case "학생번호":
						selectType="id";
						break type;
					case "이름":
						selectType="name";
						break type;
					case "국어":
						selectType="kor";
						break type;
					case "영어":
						selectType="eng";
						break type;
					case "수학":
						selectType="math";
						break type;
					case"":
						new StudentDAO().readStudent();
						continue main;
					default:
						System.out.println("다시 입력해주세요.");
					}
				}
				String searchStr;
				System.out.println("검색할 값을 입력해주세요.");
				searchStr=scan.nextLine();
				new Controller().readInput(selectType, searchStr);
				break;
			case "3":
				System.out.println("수정할 학생의 학번 혹은 이름을 입력해주세요.");
				String updateStr=scan.nextLine();
				new Controller().updateInput(updateStr);
				break;
			case "4":
				System.out.println("삭제할 학생의 학번 혹은 이름을 입력해주세요.");
				String dedateStr=scan.nextLine();
				new Controller().deleteInput(dedateStr);
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}
}