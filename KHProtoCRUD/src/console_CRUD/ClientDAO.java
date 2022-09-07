package console_CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAO {
	Client login(Client client) {
		String sql="select * from clientinfo where client_id='"+client.getID()+"' and client_pw='"+client.getPW()+"'";
		try(Connect con=new Connect();ResultSet rs=con.pstmt(sql).executeQuery();) {
			if(rs.next()==false) {
				return null;
			}
			else {
				Client checkClient = new Client(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5)));
				return checkClient;
			}
		} catch (Exception e) {//rs 가 반환 안되고 에러 날 경우.
			System.out.println("로그인 오류");
			e.printStackTrace();
			return null;
		}
	}
	public Client signup(Client cli) {
		String sql="insert into clientinfo values(?,?,?,?,?)";
		try(Connect con = new Connect();PreparedStatement signupPs = con.pstmt(sql);) {
			signupPs.setString(1, cli.getID());
			signupPs.setString(2, cli.getPW());
			signupPs.setString(3, cli.getNickname());
			signupPs.setString(4, Integer.toString(cli.getPhone()));
			signupPs.setString(5, Integer.toString(cli.getLevels()));
			signupPs.executeQuery();;
			return cli;
		} catch (Exception e) {
			System.out.println("회원 가입실패");
			e.printStackTrace();
			return null;
		}
	}
	public Client updateSign(Client cli) {
		String sql="update clientinfo set client_pw='"+cli.getPW()+"', client_ename='"+cli.getNickname()+"', client_phone='"+cli.getPhone()+"' where client_id='"+cli.getID()+"' and levels='"+cli.getLevels()+"'";
		try(Connect con = new Connect();) {
			con.pstmt(sql).executeUpdate();
			return cli;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Client deleteSign(Client cli) {
		String sql="delete from clientinfo where client_id='"+cli.getID()+"' and levels='"+cli.getLevels()+"'";
		try(Connect con = new Connect();) {
			con.pstmt(sql).executeUpdate();
			sql="delete from noticeboard where client_id='"+cli.getID()+"'";
			con.pstmt(sql).executeUpdate();
			return cli;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}