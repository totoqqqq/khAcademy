package day009;

class Arithmetic {
	int Plus(int x, int y) {
		return x+y;
	}
	
	int Minus(int x, int y) {
		return x-y;
	}
	
	int Multiply(int x, int y) {
		return x*y;
	}
	
	double Divide(int x, int y) {
		return (double)x/(double)y;
	}
	
	void Debug(int x, int y) {
		System.out.printf("%d + %d = %d\n",x,y,Plus(x,y));
		System.out.printf("%d - %d = %d\n",x,y,Minus(x,y));
		System.out.printf("%d * %d = %d\n",x,y,Multiply(x,y));
		System.out.printf("%d / %d = %.2f\n",x,y,Divide(x,y));
	}	
	int Bigger(int x, int y) {
		int result=(x>y?x:x<y?y:0);
		return result;
	}
}
