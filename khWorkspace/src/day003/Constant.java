package day003;

class Constant {
	Constant(){
		int a = 5; // 5 = 리터럴 상수.
		final int B = 10; // b는 final을 붙여서 상수화(변동 불가)
//		b+=a;//final이 붙은 B는 변경 될수 없음.
		System.out.println(++a*B);//연산에 사용은 가능함.		
	}
}