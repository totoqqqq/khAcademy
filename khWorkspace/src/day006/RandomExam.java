package day006;

import java.util.Random;

class RandomExam {
	RandomExam(){
		RandomExam01();
	}
	void RandomExam01(){
		//�ý��� Ÿ�� �õ� ��� ����
		@SuppressWarnings("unused")
		Random ran = new Random(System.currentTimeMillis());
//		System.out.println(ran.nextInt(45)+100);
		final int SIZE = 17;
		int[] intData = new int[SIZE];
		int localData;
		//Math ��Ű���� �̿��� ����
		System.out.println((int)(Math.random()*45)+100);
		
		for(int i=0;i<SIZE;i++) {
			localData = (int)(Math.random()*SIZE);
			intData[localData]++;
		}
		for(int i=0;i>SIZE;i++)
			System.out.print(intData[i]+" ");
	}
}
