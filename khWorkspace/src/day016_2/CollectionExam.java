package day016_2;

import java.util.ArrayList;

class CollectionExam {
	CollectionExam(){
//		exam01();
//		System.out.println();
		exam02();
	}
	void exam01() {
		String[] arr = new String[10];
		String tmp;
		arr[0]="Hello";
		arr[1]="World";
		arr[2]="Collection";
		for(int i=0;i<arr.length;i++) {
			tmp=arr[i];
			if(tmp.equals("World"))
				arr[i]=arr[i+1];
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
	}
	void exam02() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Hello");
		arr.add("World");
		arr.add("Collection");
		while(!(arr.indexOf("World")==-1))
			arr.remove(arr.indexOf("World"));
		for(String str:arr)
			System.out.print(str);
		int i =((String)arr.get(0)).length();
		System.out.println(i);
	}
}