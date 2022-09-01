package day003;

class VariableQuiz1 {
	@SuppressWarnings("unused")
	VariableQuiz1(){
		byte b = 10;
		short s = 20;
		char c = 'A';
		int i;
		float f;
		long l;
		
		s=b;//Promotion
		
//		c=b;//short 에 char 대입 char 데이터 범위밖인 음수 때문에 Cast 필요
		c=(char)b;
		
//		s=c;//short 에 char 대입 short 데이터 범위밖인 char의 2^15~2^16-1 범위 때문에 Cast 필요
		s=(short)c;
		
//		c=s;//char 에 short 대입 char 데이터 범위밖인 음수 때문에 char의 범위 때문에 Cast 필요
		c=(char)s;
		
//		i=100l;//Cast 필요(long을 int에 넣으려해서)
		i=(int)100l;
		
		l=500;//Promotion
		f=l;//Promotion (부동소수점 자료는 정수형보다 큰 type으로 취급)
		
//		f=5.11;//Cast 필요(double를 float에 넣으려해서)
		f=5.11f;
	}
}