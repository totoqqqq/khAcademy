package day003;

class Operator {
	Operator(){
		int x=10, y=20, result2;
		boolean result;
		result2=x+y;
		System.out.println(x+"+"+y+"="+result2);
		x=y=2;
		System.out.println("x="+ x++ +" y="+ ++y);
		System.out.println("x="+x+" y="+y);
		y=10;
		result=!(((x>y)||(y==x))||((x!=y)&&(x<y)));
		System.out.println(result);
	}
}
