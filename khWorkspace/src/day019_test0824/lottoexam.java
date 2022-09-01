package day019_test0824;

import java.util.ArrayList;

public class lottoexam {
	public static void main(String[] args) {
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		main:while(lotto.size()<6){
			int lottoNum=((int)(Math.random()*45))+1;
			if(lotto.size()==0) {
				lotto.add(lottoNum);
				continue;
			}
			for(int i:lotto) {
				if(i==lottoNum)
					continue main;
			}
			lotto.add(lottoNum);
		}
		lotto.sort(null);
		System.out.print("금주의 로또 번호 :");
		for(int i:lotto)
			System.out.print(" "+i);
	}
}