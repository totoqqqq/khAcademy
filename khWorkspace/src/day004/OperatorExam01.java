package day004;

class OperatorExam01 {
	private final int X;
	private final char CH;
	OperatorExam01(int X, char CH){
		this.X=X;
		this.CH=CH;
		if(this.X>10&&this.X<20)
			System.out.println("�Է¹��� "+this.X+"�� 10���� ũ�� 20���� �۴�");
		if(this.CH=='y'||this.CH=='Y')
			System.out.println("�Է¹��� "+this.CH+"�� ���ĺ� y �Ǵ� Y�� ����.");
		if((this.X>=100&&this.X<=200)||this.X==300)
			System.out.println("�Է¹��� "+this.X+"�� 100~200 ������ �����̰ų� 300�̴�.");
	}
}