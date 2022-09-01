package day015;

public class Temp {
	public int a;
	public static int b;
}

class Exam{
	Exam(){
		Static();
	}
	@SuppressWarnings("static-access")
	void Static() {
		Temp t1=new Temp();
		Temp t2=new Temp();
		t1.a=1;
		t1.b=2;
		System.out.println(t1.a+" "+t1.b);
		t2.a=3;
		t2.b=4;
		System.out.println(t2.a+" "+t2.b);
		System.out.println(t1.a+" "+t1.b);
	}
}
