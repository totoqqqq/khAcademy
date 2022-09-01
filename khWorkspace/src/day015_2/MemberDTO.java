package day015_2;

class MemberDTO {
	private String name;
	private int id, point, bonus;
	MemberDTO(int id, String name, int point){
		this.id=id;
		this.name=name;
		this.point=point;
		this.bonus=1;
	}
	MemberDTO(int id, String name, int point, int bonus){
		this.id=id;
		this.name=name;
		this.point=point;
		this.bonus=bonus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}