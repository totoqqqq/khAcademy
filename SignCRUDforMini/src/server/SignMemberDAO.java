package server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignMemberDAO  {
	private static SignMemberDAO smDAO=null;
	private SignMemberDAO(){
	}
	public static SignMemberDAO getInstance() {
		if(smDAO==null)
			smDAO=new SignMemberDAO();
		return smDAO;
	}
	public synchronized int createSign(SignMember sm) {
		String sql="insert into signmember values(?,?,?,?,sign_no_seq.nextval,default)";
		try(Connect con = new Connect();PreparedStatement ps=con.pstmt(sql);){
			ps.setString(1, sm.getSign_id());
			ps.setString(2, sm.getSign_pw());
			ps.setString(3, sm.getNickname());
			ps.setString(4, Integer.toString(sm.getPhone()));
			int check=ps.executeUpdate();
			System.out.println(check);
			return check;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public synchronized int login(SignMember sm) {
		String sql="select * from signmember where sign_id='"+sm.getSign_id()+"' and sign_pw='"+sm.getSign_pw()+"'";
		try(Connect con = new Connect();ResultSet rs=con.pstmt(sql).executeQuery();){
			if(rs.next()==true)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
