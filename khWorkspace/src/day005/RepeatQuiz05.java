package day005;

class RepeatQuiz05 {
	RepeatQuiz05(){
		final int arrSize = 10;
		int[][] numberArr = new int[arrSize][arrSize];
		for(int i=0;i<numberArr.length;i++) {
			for(int j=0;j<numberArr[0].length;j++)
				numberArr[i][j]=i*10+j;
		}
		arrExport : for(int i=0;i<numberArr.length;i++) {
			for(int j=0;j<numberArr.length;j++) {
				if(i+j>numberArr.length) {
					if(i<j)
						break;
					else		
						break arrExport;
				}
				else
					System.out.println(numberArr[i][j]=i*10+j);
			}
		}
	}
}