package day016;

import java.sql.SQLException;

class MemberDelete {
	private Connect con=new Connect();
	MemberDelete(String id){
		String deleteStr="delete from exam where id="+id;
		try {
			con.pstmt(deleteStr).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ȸ����ȣ "+id+"���� �����Ǿ����ϴ�.");
	}
}