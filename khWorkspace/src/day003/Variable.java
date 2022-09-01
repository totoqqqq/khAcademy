package day003;

class Variable {
	Variable(){
//		실행할 메소드 활성화
//		this.byteVariable();
//		this.shortVariable();
//		this.intVariable();
//		this.longVariable();
//		this.charVariable();
//		this.floatVariable();
//		this.doubleVariable();
		this.stringVariable();
//		this.objectVariable();
	}
	void byteVariable(){
		byte byteVariable;//변수 생성
		byteVariable=(byte)127;//변수에 최대값 삽입
		System.out.println("+"+byteVariable+" : byte type의 최대값(숫자만 들어가며 2^8의 범위를 표현 가능하다.)");
		byteVariable++;//+1를 하여 오버플로우
		System.out.println(byteVariable+" : +1를 더해서 오버플로우 현상으로 인한 byte type의 최소값(범위 -128 ~ +127)");
	}
	void shortVariable(){
		short shortVariable;//변수 생성
		shortVariable=(short)32767;//변수에 최대값 삽입
		System.out.println("+"+shortVariable+" : short type의 최대값(숫자만 들어가며 2^16의 범위를 표현 가능하다.)");
		shortVariable++;//+1를 하여 오버플로우
		System.out.println(shortVariable+" : +1를 더해서 오버플로우 현상으로 인한 short type의 최소값(범위 -32768 ~ +32767)");
	}
	void intVariable(){
		int intVariable=1;//변수 생성
		for(int i=0;i<31;i++)
			intVariable*=2;//2^31 실행
		intVariable--;//변수에 최대값 삽입
		System.out.println("+"+intVariable+" : int type의 최대값(숫자만 들어가며 2^32의 범위를 표현 가능하다.)");
		intVariable++;//+1를 하여 오버플로우
		System.out.println(intVariable+" : +1를 더해서 오버플로우 현상으로 인한 int type의 최소값(type 범위 -2^31 ~ +2^31-1)");
	}
	void longVariable(){
		long longVariable=1;//변수 생성
		for(int i=0;i<63;i++)
			longVariable*=2;//2^63 실행
		longVariable--;//변수에 최대값 삽입
		System.out.println("+"+longVariable+" : long type의 최대값(숫자만 들어가며 2^64의 범위를 표현 가능하다.)");
		longVariable++;//+1를 하여 오버플로우
		System.out.println(longVariable+" : +1를 더해서 오버플로우 현상으로 인한 long type의 최소값(type 범위 -2^63 ~ +2^63-1)");
	}
	void charVariable() {
		char charVariable='A';//65에 대응.
		System.out.println("'"+charVariable + "' : char type은 ASCII의 문자값에 해당하는 숫자이며 " + ((int)charVariable+(int)50) +" = ('A'+(int)50) 정수형 변수타입과 연산이 가능하다.");
		System.out.println("'"+(char)65535+"' : char type는 음수가 없이 0 ~ 65535에 해당하는 문자를 저장한다.");
	}
	void floatVariable() {
		float floatVariable=3.14f; //기본적으로 소숫점은 double d에 대응해서 f라는 명시 필수
		System.out.println(floatVariable);
	}
	void doubleVariable() {
		double doubleVariable=5.12; //기본적으로 실수형 type은 소숫점 정밀도에 더 치중된다.
		System.out.println(doubleVariable);
	}
	void booleanVariable() {
		boolean booleanVariable=true;
		System.out.println(booleanVariable+" : boolean type은 참(true),  거짓(false)만 저장한다.");
	}
	void stringVariable() {
		String stringVariable="참조형 변수 : heap 메모리에는 데이터 값을, stack 메모리에는 저장된 Heap 메모리 데이터의 주소을 저장.";
		System.out.println(stringVariable);
	}
	void objectVariable() {
		Object objectVariable="A"+(char)((int)10+'A')+((long)17+30)+ ": 오브젝트 타입은 구분없이 다 저장한다";
		System.out.println(objectVariable);
	}
}
