package day004;

class OperatorQuiz01 {
	OperatorQuiz01(){
		int a=10, b=20;
		System.out.println(++a==10&&b++==20);
		//++a �� a�� 11�� �Ǿ 11==10�� false�� �Ǿ��� &&(and����) ���ǻ� false Ȯ������ �޺κ���
		//b++==20 �� ����, ++���������� ��ŵ�ϰ� ������������ �Ѿ�ϴ�.(�ڹ��� �� ����) 
		System.out.println(a+":"+b);
		//���� 11:20 ��� �˴ϴ�.
	}
}
