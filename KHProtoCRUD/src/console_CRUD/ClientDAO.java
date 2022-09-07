package console_CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
	Client login(Client client) {
		Connect con=new Connect();
		String sql="select * from clientinfo where client_id='"+client.getID()+"' and client_pw='"+client.getPW()+"'";
		ResultSet rs;
		try {
			rs=con.pstmt(sql).executeQuery();
			if(rs.next()==false) {
				rs.close();
				con.close();
				return null;
			}
			else {
				Client checkClient = new Client(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5)));
				rs.close();
				con.close();
				return checkClient;
			}
		} catch (SQLException e) {//rs 가 반환 안되고 에러 날 경우.
			System.out.println("로그인 오류");
			e.printStackTrace();
			con.close();
			return null;
		}
	}
	public Client signup(Client cli) {
		Connect con = new Connect();
		String sql="insert into clientinfo values(?,?,?,?,?)";
		PreparedStatement signupPs = con.pstmt(sql);
		try {
			signupPs.setString(1, cli.getID());
			signupPs.setString(2, cli.getPW());
			signupPs.setString(3, cli.getNickname());
			signupPs.setString(4, Integer.toString(cli.getPhone()));
			signupPs.setString(5, Integer.toString(cli.getLevels()));
			signupPs.executeQuery();
			signupPs.close();
			con.close();
			return cli;
		} catch (SQLException e) {
			System.out.println("회원 가입실패");
			e.printStackTrace();
			con.close();
			return null;
		}
	}
	public Client updateSign(Client cli) {
		Connect con = new Connect();
		String sql="update clientinfo set client_pw='"+cli.getPW()+"', client_ename='"+cli.getNickname()+"', client_phone='"+cli.getPhone()+"' where client_id='"+cli.getID()+"' and levels='"+cli.getLevels()+"'";
		try {
			con.pstmt(sql).executeUpdate();
			con.pstmt(sql).close();
			con.close();
			return cli;
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return null;
		}
	}
}