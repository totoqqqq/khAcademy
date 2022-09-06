package day020;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KHDAO {
	void insert(KHDTO input) {
		String sql="insert into cafe_menu values(?,?,?,?)";
		Connect con = new Connect();
		PreparedStatement insert = con.pstmt(sql);
		try {
			insert.setString(1,Integer.toString(input.getPid()));
			insert.setString(2, input.getPname());
			insert.setString(3, Integer.toString(input.getPrice()));
			insert.setString(4, (input.isIced()==true?"Y":"N"));
			insert.executeUpdate();
			insert.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	ArrayList<KHDTO> select(String search) {
		ResultSet rs=null;
		Connect con = new Connect();
		ArrayList<KHDTO> rsArr = new ArrayList<KHDTO>();
		if(search==null) {
			try {
				rs=con.pstmt("select * from cafe_menu").executeQuery();
				while(rs.next())
					rsArr.add(new KHDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),(rs.getString(4).equals("Y")?true:false)));
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsArr;
	}		 
}