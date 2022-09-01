package day003;

class Variable {
	Variable(){
//		������ �޼ҵ� Ȱ��ȭ
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
		byte byteVariable;//���� ����
		byteVariable=(byte)127;//������ �ִ밪 ����
		System.out.println("+"+byteVariable+" : byte type�� �ִ밪(���ڸ� ���� 2^8�� ������ ǥ�� �����ϴ�.)");
		byteVariable++;//+1�� �Ͽ� �����÷ο�
		System.out.println(byteVariable+" : +1�� ���ؼ� �����÷ο� �������� ���� byte type�� �ּҰ�(���� -128 ~ +127)");
	}
	void shortVariable(){
		short shortVariable;//���� ����
		shortVariable=(short)32767;//������ �ִ밪 ����
		System.out.println("+"+shortVariable+" : short type�� �ִ밪(���ڸ� ���� 2^16�� ������ ǥ�� �����ϴ�.)");
		shortVariable++;//+1�� �Ͽ� �����÷ο�
		System.out.println(shortVariable+" : +1�� ���ؼ� �����÷ο� �������� ���� short type�� �ּҰ�(���� -32768 ~ +32767)");
	}
	void intVariable(){
		int intVariable=1;//���� ����
		for(int i=0;i<31;i++)
			intVariable*=2;//2^31 ����
		intVariable--;//������ �ִ밪 ����
		System.out.println("+"+intVariable+" : int type�� �ִ밪(���ڸ� ���� 2^32�� ������ ǥ�� �����ϴ�.)");
		intVariable++;//+1�� �Ͽ� �����÷ο�
		System.out.println(intVariable+" : +1�� ���ؼ� �����÷ο� �������� ���� int type�� �ּҰ�(type ���� -2^31 ~ +2^31-1)");
	}
	void longVariable(){
		long longVariable=1;//���� ����
		for(int i=0;i<63;i++)
			longVariable*=2;//2^63 ����
		longVariable--;//������ �ִ밪 ����
		System.out.println("+"+longVariable+" : long type�� �ִ밪(���ڸ� ���� 2^64�� ������ ǥ�� �����ϴ�.)");
		longVariable++;//+1�� �Ͽ� �����÷ο�
		System.out.println(longVariable+" : +1�� ���ؼ� �����÷ο� �������� ���� long type�� �ּҰ�(type ���� -2^63 ~ +2^63-1)");
	}
	void charVariable() {
		char charVariable='A';//65�� ����.
		System.out.println("'"+charVariable + "' : char type�� ASCII�� ���ڰ��� �ش��ϴ� �����̸� " + ((int)charVariable+(int)50) +" = ('A'+(int)50) ������ ����Ÿ�԰� ������ �����ϴ�.");
		System.out.println("'"+(char)65535+"' : char type�� ������ ���� 0 ~ 65535�� �ش��ϴ� ���ڸ� �����Ѵ�.");
	}
	void floatVariable() {
		float floatVariable=3.14f; //�⺻������ �Ҽ����� double d�� �����ؼ� f��� ��� �ʼ�
		System.out.println(floatVariable);
	}
	void doubleVariable() {
		double doubleVariable=5.12; //�⺻������ �Ǽ��� type�� �Ҽ��� ���е��� �� ġ�ߵȴ�.
		System.out.println(doubleVariable);
	}
	void booleanVariable() {
		boolean booleanVariable=true;
		System.out.println(booleanVariable+" : boolean type�� ��(true),  ����(false)�� �����Ѵ�.");
	}
	void stringVariable() {
		String stringVariable="������ ���� : heap �޸𸮿��� ������ ����, stack �޸𸮿��� ����� Heap �޸� �������� �ּ��� ����.";
		System.out.println(stringVariable);
	}
	void objectVariable() {
		Object objectVariable="A"+(char)((int)10+'A')+((long)17+30)+ ": ������Ʈ Ÿ���� ���о��� �� �����Ѵ�";
		System.out.println(objectVariable);
	}
}
