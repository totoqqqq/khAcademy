package day003;

class VariableCast {
	VariableCast(){
	byte byteVariable = 0;
	short shortVariable = 500;
	byteVariable = (byte)shortVariable;
	System.out.println(byteVariable + " : byte 0에 short 500을 byte로 캐스팅");
	}
}