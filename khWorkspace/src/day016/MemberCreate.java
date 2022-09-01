package day016;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class MemberCreate{
	private Scanner scan=new Scanner(System.in);
	private Connect con=new Connect();
	MemberCreate(){
		String[] title = {"ȸ����ȣ","�޴���ȭ��ȣ(-���� �Է�)","����Ʈ","���ʽ�(%)","ȸ�����(0.Bronze 1.Silver 2.Gold 3.VIP etc. Unknwon)"};
		String sql="insert into exam values (?,?,?,?,?,?)";
		try {
			PreparedStatement order = con.pstmt(sql);
			System.out.println("�̸��� �Է����ּ���.");
			order.setString(2, scan.nextLine());
			for(int i=0;i<title.length;i++) {
				System.out.print(title[i]+"��(��) �Է����ּ���.");
				if(i==0) 
					order.setInt(i+1, numCheck(scan.nextLine()));
				else if(i==1) 
					order.setString(i+2, "0"+Integer.toString(numCheck(scan.nextLine())));
				else
					order.setInt(i+2, numCheck(scan.nextLine()));
			}
			order.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�Է��� �߸� �ϼ̰ų� �ߺ��� �ֽ��ϴ�. �ٽ� �Է� ��Ź�帳�ϴ�.");
		}
		con.close();
	}
	private int numCheck(String num) {//�Է°��� int ������ üũ.
		while(true) {
			try {
				return Integer.parseInt(num);
			}catch(NumberFormatException e) {
				System.out.println("[�Է� ����]���ڸ� �Է����ּ���.");
				num=scan.nextLine();
			}
		}
	}
}