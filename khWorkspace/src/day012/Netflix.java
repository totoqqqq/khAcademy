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
	final private String[] MOVIETYPE = {"�׼�","����","�ϻ�","����","����"};
	Scanner scan = new Scanner(System.in);

	Active(){
		while(true)
			MainMenu();
	}
	
	void MainMenu(){
		int selectMenu;
		while(true) {
			System.out.println("<< Netflix >>\n�޴��� ������ �����ּ���.\n1. �ű� ��ȭ ���\n2. ��ȭ ��� ���\n3. ��ȭ �˻�\n4. ���α׷� ���� ");
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
				System.out.println("���α׷��� ���� �մϴ�.");
				System.exit(0);
			default:
				System.out.println("�޴��� ��ȣ�� �ٽ� �Է����ּ���.");
			}
		}	
	}
	
//	void UpdateMovie() {
//		String searchMovie;
//		int index;
//		System.out.println("���� �� ��ȭ���� �Է����ּ���.");
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
		System.out.println("��ȭ�� �̸��� �Է����ּ���.");
		name = scan.nextLine();
		System.out.print("��ȭ�� �帣�� �Է����ּ���. |");
		for(int i=0;i<MOVIETYPE.length;i++)
			System.out.print(MOVIETYPE[i]+"|");
		type = MovieTypeCheck(scan.nextLine());
		while(true) {
			System.out.print("��ȭ ������ �Է����ּ���(0 ~ 10��)");
			score = (float)NumCheck(scan.nextLine());
			if(score>=0&&score<=10)
				break;
			else
				System.out.println("���� ���� ������ �ٽ� �Է����ּ���.");
		}
		this.nets.add(new Netflix(name,type,score));
	}
	
	void ViewMovies() {
		if(this.nets.size()==0) {
			System.out.println("����� ��ȭ ����� �����ϴ�.");
			return;
		}
		System.out.println("����\t\t�帣\t����");
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
			System.out.println("����� ��ȭ ����� �����ϴ�.");
			return;
		}
		search:while(true) {
			System.out.print("�˻��� ��ȭ��, �帣�� �Է��Ͻʽÿ�.(0 ���Է½� ���� �޴�)");
			searchName=scan.nextLine();
			for(int i=0;i<this.nets.size();i++) {
				if(this.nets.get(i).getName().contains(searchName)==true||this.nets.get(i).getType().equals(searchName)==true)
					break search;
				else if(searchName.equals("0")) {
					System.out.println("�޴��� ���ư��ϴ�.");
					return;
				}
			}
			System.out.println(searchName+"�˻��� ã�� �� �����ϴ�.");
		}
		System.out.println("����\t\t�帣\t����");
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
			System.out.print("��ȭ �帣�� �ٽ� �Է����ּ���. |");
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
				System.out.println("�ٽ� �Է����ּ���.(���ڸ� �Է����ּ���.)");
				num = scan.nextLine();
			}
		}
	}
}