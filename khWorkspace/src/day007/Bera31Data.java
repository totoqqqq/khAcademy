package day007;

import java.util.Scanner;

class Bera31Data {
	private int gameWin=0,gameLose=0;
	final int MAXCOUNT=31;
	int your, computer, numberLocation;
	Scanner scan=new Scanner(System.in);
	
	public int[] getGameCount() {
		int gameWin=this.gameWin;
		int gameLose=this.gameLose;
		return new int[] {gameWin, gameLose};
	}
	
	public void setGameCount(int gameWin, int gameLose) {
		this.gameWin+=gameWin;
		this.gameLose+=gameLose;
	}
}