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
		
//		c=b;//short �� char ���� char ������ �������� ���� ������ Cast �ʿ�
		c=(char)b;
		
//		s=c;//short �� char ���� short ������ �������� char�� 2^15~2^16-1 ���� ������ Cast �ʿ�
		s=(short)c;
		
//		c=s;//char �� short ���� char ������ �������� ���� ������ char�� ���� ������ Cast �ʿ�
		c=(char)s;
		
//		i=100l;//Cast �ʿ�(long�� int�� �������ؼ�)
		i=(int)100l;
		
		l=500;//Promotion
		f=l;//Promotion (�ε��Ҽ��� �ڷ�� ���������� ū type���� ���)
		
//		f=5.11;//Cast �ʿ�(double�� float�� �������ؼ�)
		f=5.11f;
	}
}