package day009;

public class Run {
	public static void main(String[] args) {
//		Arithmetic arith = new Arithmetic();
//		arith.Debug(10, 3);
//		System.out.println(arith.Bigger(10, 3));
//		System.out.println(arith.Bigger(10, 33));
//		System.out.println(arith.Bigger(310, 310));
		Translate trans = new Translate();
		System.out.println(trans.Word("사과"));
		System.out.println(trans.Word("포도"));
		System.out.println(trans.Word("딸기"));
	}
}