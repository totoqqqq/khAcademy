package day003;

class VariablePromotion {
	VariablePromotion(){
		short shortNum=0;
		byte byteNum=10;
		shortNum+=byteNum;
		System.out.println(shortNum+" : ���θ�� ����, short + byte = short");
		System.out.printf("%s / %.0f = %.2f : ���θ�� ����, short + float = float", shortNum,3f,shortNum/3f);
	}
}