package day004;

class OperatorExam01 {
	private final int X;
	private final char CH;
	OperatorExam01(int X, char CH){
		this.X=X;
		this.CH=CH;
		if(this.X>10&&this.X<20)
			System.out.println("입력받은 "+this.X+"는 10보다 크고 20보다 작다");
		if(this.CH=='y'||this.CH=='Y')
			System.out.println("입력받은 "+this.CH+"는 알파벳 y 또는 Y와 같다.");
		if((this.X>=100&&this.X<=200)||this.X==300)
			System.out.println("입력받은 "+this.X+"는 100~200 사이의 숫자이거나 300이다.");
	}
}