package console_CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NoticeboardDAO {
	Noticeboard createContent(Noticeboard nb) {
		Connect con = new Connect();
		String sql="insert into noticeboard values(NOTICEBOARD_NO.nextval,?,?,?,sysdate)";
		try {
			PreparedStatement conNb = con.pstmt(sql);
			conNb.setString(1, nb.getTitle());
			conNb.setString(2, nb.getContent());
			conNb.setString(3, nb.getID());
			conNb.executeUpdate();
			conNb.close();
			con.close();
			return nb;
		} catch (SQLException e) {
			System.out.println("글 작성 실패");
			e.printStackTrace();
			con.close();
			return null;
		}
	}
	public ArrayList<Noticeboard> readContent() {
		Connect con = new Connect();
		String sql = "select * from noticeboard noti left join cliinfoview clii on noti.client_id=clii.client_id order by mb_no";
		try {
			ResultSet rs = con.pstmt(sql).executeQuery();
			ArrayList<Noticeboard> nbs = new ArrayList<Noticeboard>();
			while(rs.next()) {
				nbs.add(new Noticeboard(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getString(7)));
			}
			rs.close();
			con.close();
			return nbs;
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return null;
		}
	}

	public Noticeboard editSearchContent(int i, Client clientLogin) {
		Connect con = new Connect();
		String sql = "select * from noticeboard noti left join cliinfoview clii on noti.client_id=clii.client_id where mb_no='"+i+"' and noti.client_id='"+clientLogin.getID()+"'";
		try {
			ResultSet rs = con.pstmt(sql).executeQuery();
			if(rs.next()==false) 
				return null;
			Noticeboard esc = new Noticeboard(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getString(7));
			rs.close();
			con.close();
			return esc;
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return null;
		}
	}
	public Noticeboard updateContent(Noticeboard nb) {
		Connect con = new Connect();
		String sql = "update noticeboard set mb_title='"+nb.getTitle()+"', mb_content='"+nb.getContent()+"' where mb_no='"+nb.getNo()+"'";
		try {
			con.pstmt(sql).executeUpdate();
			con.pstmt(sql).close();
			con.close();
			return nb;
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return null;
		}
	}
	public Noticeboard deleteContent(Noticeboard nb) {
		Connect con = new Connect();
		String sql = "delete from noticeboard where mb_no='"+nb.getNo()+"' and client_id='"+nb.getID()+"'";
		try {
			con.pstmt(sql).executeUpdate();
			con.pstmt(sql).close();
			con.close();
			return nb;
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return null;
		}
	}
	public boolean deleteContentAD(String deleteKey) {
		Connect con = new Connect();
		String sql = "delete from noticeboard where mb_title like '%"+deleteKey+"%' or client_id like '%"+deleteKey+"%'";
		try {
			con.pstmt(sql).executeUpdate();
			con.pstmt(sql).close();
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return false;
		}
	}
}