package day003;

class VariableCast {
	VariableCast(){
	byte byteVariable = 0;
	short shortVariable = 500;
	byteVariable = (byte)shortVariable;
	System.out.println(byteVariable + " : byte 0�� short 500�� byte�� ĳ����");
	}
}