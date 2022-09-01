package day004;

class OperatorQuiz01 {
	OperatorQuiz01(){
		int a=10, b=20;
		System.out.println(++a==10&&b++==20);
		//++a 로 a가 11이 되어서 11==10이 false가 되었고 &&(and연산) 조건상 false 확정으로 뒷부분인
		//b++==20 비교 연산, ++증감연산을 스킵하고 다음라인으로 넘어갑니다.(자바의 숏 연산) 
		System.out.println(a+":"+b);
		//따라서 11:20 출력 됩니다.
	}
}
