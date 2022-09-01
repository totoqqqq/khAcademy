package day012;

import java.util.ArrayList;
import java.util.Scanner;

class Netflix {
	private String name, type;
	private float score;

	Netflix(String name, String type, float score){
		this.name=name;
		this.type=type;
		this.score=score;
	}
	Netflix(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

class Active {
	private ArrayList<Netflix> nets = new ArrayList<Netflix>();
	final private String[] MOVIETYPE = {"액션","순정","일상","개그","역사"};
	Scanner scan = new Scanner(System.in);

	Active(){
		while(true)
			MainMenu();
	}
	
	void MainMenu(){
		int selectMenu;
		while(true) {
			System.out.println("<< Netflix >>\n메뉴를 선택해 눌러주세요.\n1. 신규 영화 등록\n2. 영화 목록 출력\n3. 영화 검색\n4. 프로그램 종료 ");
			selectMenu=(int)NumCheck(scan.nextLine());
			switch(selectMenu) {
			case 1:
				InputMovie();
				break;
			case 2:
				ViewMovies();
				break;
			case 3:
				SearchMovie();
				break;
			case 4:
				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);
			default:
				System.out.println("메뉴의 번호를 다시 입력해주세요.");
			}
		}	
	}
	
//	void UpdateMovie() {
//		String searchMovie;
//		int index;
//		System.out.println("수정 할 영화명을 입력해주세요.");
//		searchMovie=scan.nextLine();
//		for(int i=0;i<this.nets.size();i++) {
//			if(this.nets.get(i).getName().equals(searchMovie)) {
//				
//			}	
//		}
//	}
	
	void InputMovie() {
		String name, type;
		float score;
		System.out.println("영화의 이름을 입력해주세요.");
		name = scan.nextLine();
		System.out.print("영화의 장르를 입력해주세요. |");
		for(int i=0;i<MOVIETYPE.length;i++)
			System.out.print(MOVIETYPE[i]+"|");
		type = MovieTypeCheck(scan.nextLine());
		while(true) {
			System.out.print("영화 평점을 입력해주세요(0 ~ 10점)");
			score = (float)NumCheck(scan.nextLine());
			if(score>=0&&score<=10)
				break;
			else
				System.out.println("점수 범위 내에서 다시 입력해주세요.");
		}
		this.nets.add(new Netflix(name,type,score));
	}
	
	void ViewMovies() {
		if(this.nets.size()==0) {
			System.out.println("저장된 영화 목록이 없습니다.");
			return;
		}
		System.out.println("제목\t\t장르\t평점");
		for(int i=0;i<this.nets.size();i++) {
			if(this.nets.get(i).getName().length()<6)
				System.out.printf(this.nets.get(i).getName()+"\t\t"+this.nets.get(i).getType()+"\t%.2f\n",this.nets.get(i).getScore());
			else
				System.out.printf(this.nets.get(i).getName()+"\t"+this.nets.get(i).getType()+"\t%.2f\n",this.nets.get(i).getScore());
		}
	}
	
	void SearchMovie() {
		String searchName;
		if(this.nets.size()==0) {
			System.out.println("저장된 영화 목록이 없습니다.");
			return;
		}
		search:while(true) {
			System.out.print("검색할 영화명, 장르를 입력하십시요.(0 ←입력시 이전 메뉴)");
			searchName=scan.nextLine();
			for(int i=0;i<this.nets.size();i++) {
				if(this.nets.get(i).getName().contains(searchName)==true||this.nets.get(i).getType().equals(searchName)==true)
					break search;
				else if(searchName.equals("0")) {
					System.out.println("메뉴로 돌아갑니다.");
					return;
				}
			}
			System.out.println(searchName+"검색어 찾을 수 없습니다.");
		}
		System.out.println("제목\t\t장르\t평점");
		for(int i=0;i<this.nets.size();i++) {
			if(this.nets.get(i).getName().contains(searchName)==true||this.nets.get(i).getType().equals(searchName)==true) {
				if(this.nets.get(i).getName().length()<6)
					System.out.printf(this.nets.get(i).getName()+"\t\t"+this.nets.get(i).getType()+"\t%.2f\n",this.nets.get(i).getScore());
				else
					System.out.printf(this.nets.get(i).getName()+"\t"+this.nets.get(i).getType()+"\t%.2f\n",this.nets.get(i).getScore());
			}
		}
	}
	
	String MovieTypeCheck(String type) {
		while(true) {
			for(int i=0;i<MOVIETYPE.length;i++) {
				if(type.equals(MOVIETYPE[i]))
					return type;
			}
			System.out.print("영화 장르를 다시 입력해주세요. |");
			for(int i=0;i<MOVIETYPE.length;i++)
				System.out.print(MOVIETYPE[i]+"|");
			type=scan.nextLine();
		}
	}
	
	float NumCheck(String num) {
		while(true) {
			try {
				return Float.parseFloat(num);
			}catch(NumberFormatException e) {
				System.out.println("다시 입력해주세요.(숫자를 입력해주세요.)");
				num = scan.nextLine();
			}
		}
	}
}