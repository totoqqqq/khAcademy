package day016;

import java.sql.ResultSet;
import java.sql.SQLException;

class MemberRead {
	private Connect con=new Connect();
	private ResultSet rs=null;
	MemberRead(){//��ü��ȸ
		System.out.println("ȸ����ȣ\t�̸�\t�޴���ȭ\t\t����Ʈ\t���ʽ�(%)\t���");
		try {
			rs=this.con.pstmt("select * from exam order by id").executeQuery();
			readSQL(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	MemberRead(String type,String searchStr){// Ư�� �˻��� �˻�
		System.out.println("ȸ����ȣ\t�̸�\t�޴���ȭ\t\t����Ʈ\t���ʽ�(%)\t���");
		try {
			rs=con.pstmt("select * from exam where "+type+" like '%"+searchStr+"%' order by id").executeQuery();
			readSQL(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void readSQL(ResultSet rs) {
		try {
			while(rs.next())
				System.out.printf("%d\t%s\t%s\t%d\t%d\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),(rs.getInt(6)==0?"Bronze":rs.getInt(6)==1?"Silver":rs.getInt(6)==2?"Gold":rs.getInt(6)==3?"VIP":"Unknows"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.con.close();
	}
}