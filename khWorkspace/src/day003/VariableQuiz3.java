package day003;

class VariableQuiz3 {
	VariableQuiz3(){
		int i1=10, i2=20;
		float f1 = 3.14f;
		char c1='A', c2='B';
		System.out.println("결과 : "+i1+i2);
		System.out.println("결과 : "+(i1+i2));
		System.out.println("결과 : "+i1+f1);
		System.out.println("결과 : "+(i1+f1));
		System.out.println("결과 : "+f1+c1);
		System.out.println("결과 : "+(f1+c1));
		System.out.println("결과 : "+c1+c2);
		System.out.println("결과 : "+(c1+c2));
	}
}
