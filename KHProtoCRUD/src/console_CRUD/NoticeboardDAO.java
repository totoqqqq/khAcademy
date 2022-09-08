package console_CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NoticeboardDAO {
	private static NoticeboardDAO nbDAO = null;
	private NoticeboardDAO(){
	}
	public static NoticeboardDAO getInstance(){
		if(nbDAO==null)
			nbDAO=new NoticeboardDAO();
		return nbDAO;
	}
	Noticeboard createContent(Noticeboard nb) {
		String sql="insert into noticeboard values(NOTICEBOARD_NO.nextval,?,?,?,sysdate)";
		try(Connect con = new Connect();PreparedStatement conNb = con.pstmt(sql);) {
			conNb.setString(1, nb.getTitle());
			conNb.setString(2, nb.getContent());
			conNb.setString(3, nb.getID());
			conNb.executeUpdate();
			conNb.close();
			return nb;
		} catch (Exception e) {
			System.out.println("글 작성 실패");
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Noticeboard> readContent() {
		String sql = "select * from noticeboard noti left join cliinfoview clii on noti.client_id=clii.client_id order by mb_no";
		try(Connect con = new Connect();ResultSet rs = con.pstmt(sql).executeQuery();) {
			ArrayList<Noticeboard> nbs = new ArrayList<Noticeboard>();
			while(rs.next()) {
				nbs.add(new Noticeboard(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getString(7)));
			}
			return nbs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Noticeboard editSearchContent(int i, Client clientLogin) {
		String sql = "select * from noticeboard noti left join cliinfoview clii on noti.client_id=clii.client_id where mb_no='"+i+"' and noti.client_id='"+clientLogin.getID()+"'";
		try(Connect con = new Connect();ResultSet rs = con.pstmt(sql).executeQuery();) {
			if(rs.next()==false) 
				return null;
			Noticeboard esc = new Noticeboard(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getString(7));
			return esc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Noticeboard updateContent(Noticeboard nb) {
		String sql = "update noticeboard set mb_title='"+nb.getTitle()+"', mb_content='"+nb.getContent()+"' where mb_no='"+nb.getNo()+"'";
		try(Connect con = new Connect();) {
			con.pstmt(sql).executeUpdate();
			return nb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Noticeboard deleteContent(Noticeboard nb) {
		String sql = "delete from noticeboard where mb_no='"+nb.getNo()+"' and client_id='"+nb.getID()+"'";
		try(Connect con = new Connect();) {
			con.pstmt(sql).executeUpdate();
			return nb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteContentAD(String deleteKey) {
		String sql = "delete from noticeboard where mb_title like '%"+deleteKey+"%' or client_id like '%"+deleteKey+"%'";
		try(Connect con = new Connect();) {
			con.pstmt(sql).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}