package day003;

class FinalExam1 {
	private final int age;//final 변수 선언
	FinalExam1(int age){
		this.age=age;//입력받은 int 값을 final 변수값에 대입 추후 변경 불가.
		System.out.println("입력 받은 나이는 "+this.age+" 살 입니다.");
	}
}