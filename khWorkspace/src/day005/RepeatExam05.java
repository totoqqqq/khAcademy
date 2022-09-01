package day005;

class RepeatExam05 {
	RepeatExam05(){
		for(int i=0;i++<10;) {
			if(i==2||i==5)
				continue;
			System.out.println("i = "+i);
			if(i==8)
				break;
		}
	}
}