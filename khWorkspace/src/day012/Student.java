package day012;

import java.util.ArrayList;

class Student {
	private String name;
	private int kor, eng, sum;
	private float avg;
	Student(String name, int kor, int eng) {
		setName(name);
		setKor(kor);
		setEng(eng);
		setSum();
		setAvg();
	}
	public Student() {

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getSum() {
		return sum;
	}
	public void setSum() {
		this.sum = this.kor+this.eng;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = (float)this.sum/2;
	}
}

class ReportCard{
	ReportCard() {
		Student std = new Student("Alex",90,40);
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student());
		stds.get(0).setName("Tom");
		stds.get(0).setKor(50);
		stds.get(0).setEng(80);
		stds.get(0).setSum();
		stds.get(0).setAvg();
		stds.add(new Student("Jane",100,50));
		stds.add(std);
		PrintReportCard(stds);
	}
	void PrintReportCard(ArrayList<Student> stds){
		System.out.println("이름\t국어\t영어\t합계\t평균");
		for(int i=0;i<stds.size();i++) {
			System.out.println(stds.get(i).getName()+"\t"+stds.get(i).getKor()+"\t"+stds.get(i).getEng()+"\t"+stds.get(i).getSum()+"\t"+stds.get(i).getAvg());
		}
	}
}