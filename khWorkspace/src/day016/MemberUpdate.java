package day016;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class MemberUpdate {
	private Scanner scan=new Scanner(System.in);
	private Connect con=new Connect();
	MemberUpdate(String id){
		ResultSet rs;
		String searchStr="select * from exam where id='"+id+"'";
		MemberDTO update;
		try {
			rs=con.pstmt(searchStr).executeQuery();
			view(rs);
			update = new MemberDTO(rs.getInt(1),rs.getString(2));
		} catch (SQLException e) {
			System.out.println("�ش� ��ȣ�� ȸ���� �����ϴ�.");
			return;
		}
		String[] typeStr = {"�޴���ȭ","����Ʈ","���ʽ�","���"};
		for(String Str:typeStr){
			System.out.println("���� �� "+Str+"��(��) �Է��ϼ���.");
			switch(Str){
			case"�޴���ȭ":
				update.setPhone(scan.nextLine());
				break;
			case"����Ʈ":
				update.setPoint(Integer.parseInt(scan.nextLine()));
				break;
			case"���ʽ�":
				update.setBonus(Integer.parseInt(scan.nextLine()));
				break;
			case"���":
				update.setLevels(Integer.parseInt(scan.nextLine()));
				break;
			}
		}
		PreparedStatement updates = con.pstmt("update exam set name=?,phone=?,point=?,bonus=?,levels=? where id=?");
		try {
			updates.setString(1, update.getName());
			updates.setString(2, update.getPhone());
			updates.setString(3, Integer.toString(update.getPoint()));
			updates.setString(4, Integer.toString(update.getBonus()));
			updates.setString(5, Integer.toString(update.getLevels()));
			updates.setString(6, Integer.toString(update.getId()));
			updates.executeUpdate();
			rs=con.pstmt(searchStr).executeQuery();
			view(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void view(ResultSet rs) {
		try {
			if(rs.next()==false)
				return;
			System.out.println("ȸ����ȣ\t�̸�\t�޴���ȭ\t\t����Ʈ\t���ʽ�(%)\t���");
			System.out.printf("%d\t%s\t%s\t%d\t%d\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),(rs.getInt(6)==0?"Bronze":rs.getInt(6)==1?"Silver":rs.getInt(6)==2?"Gold":rs.getInt(6)==3?"VIP":"Unknows"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}