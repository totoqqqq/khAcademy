package day006;

import java.util.Random;

class RandomExam {
	RandomExam(){
		RandomExam01();
	}
	void RandomExam01(){
		//시스템 타임 시드 기반 난수
		@SuppressWarnings("unused")
		Random ran = new Random(System.currentTimeMillis());
//		System.out.println(ran.nextInt(45)+100);
		final int SIZE = 17;
		int[] intData = new int[SIZE];
		int localData;
		//Math 패키지를 이용한 난수
		System.out.println((int)(Math.random()*45)+100);
		
		for(int i=0;i<SIZE;i++) {
			localData = (int)(Math.random()*SIZE);
			intData[localData]++;
		}
		for(int i=0;i>SIZE;i++)
			System.out.print(intData[i]+" ");
	}
}
