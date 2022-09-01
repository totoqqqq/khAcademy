package day003;

class VariableQuiz2 {
	@SuppressWarnings("unused")
	VariableQuiz2(){
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000l;
		
		b=(byte)i;
		ch=(char)b;
		short s = (short)ch;
		float f = l;
		i=ch;
	}
}