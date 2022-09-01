package day016;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class MemberCreate{
	private Scanner scan=new Scanner(System.in);
	private Connect con=new Connect();
	MemberCreate(){
		String[] title = {"회원번호","휴대전화번호(-빼고 입력)","포인트","보너스(%)","회원등급(0.Bronze 1.Silver 2.Gold 3.VIP etc. Unknwon)"};
		String sql="insert into exam values (?,?,?,?,?,?)";
		try {
			PreparedStatement order = con.pstmt(sql);
			System.out.println("이름을 입력해주세요.");
			order.setString(2, scan.nextLine());
			for(int i=0;i<title.length;i++) {
				System.out.print(title[i]+"를(을) 입력해주세요.");
				if(i==0) 
					order.setInt(i+1, numCheck(scan.nextLine()));
				else if(i==1) 
					order.setString(i+2, "0"+Integer.toString(numCheck(scan.nextLine())));
				else
					order.setInt(i+2, numCheck(scan.nextLine()));
			}
			order.executeUpdate();
		} catch (SQLException e) {
			System.out.println("입력을 잘못 하셨거나 중복이 있습니다. 다시 입력 부탁드립니다.");
		}
		con.close();
	}
	private int numCheck(String num) {//입력값이 int 값인지 체크.
		while(true) {
			try {
				return Integer.parseInt(num);
			}catch(NumberFormatException e) {
				System.out.println("[입력 오류]숫자만 입력해주세요.");
				num=scan.nextLine();
			}
		}
	}
}