package day009;

public class Translate {
	private String[][] Word={{"Apple","Grape"},{"���","����"}};
	Translate(){
		
	}
	String Word(String str){
		String result="None";
		for(int i=0;i<this.Word.length;i++) {
			if(str.equals(Word[1][i]))
				result=Word[0][i];
		}
		return result;
	}
}
