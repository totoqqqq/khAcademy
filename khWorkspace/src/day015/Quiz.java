package day015;

class Calc {
	int plus(int x,int y) {
		return x+y;
	}
	static int minus(int x,int y) {
		return x-y;
	}
	int mply(int x,int y) {
		return x*y;
	}
	static double divide(int x, int y) {
		return x/(double)y;
	}
}

public class Quiz {
	Quiz(){
		quiz01();
	}
	void quiz01() {
		Calc c = new Calc();
		System.out.println(c.plus(10,20));//30
		System.out.println(Calc.minus(30,20));//10
		System.out.println(c.mply(5,3));//15
		System.out.printf("%.1f",Calc.divide(10,2));//5
	}
}