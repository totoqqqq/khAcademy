package day021_test06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopMemberDAO {
	public ShopMember searchUser(String memberId) {
		ShopMember shopMember = new ShopMember();
		String query = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID ='" + memberId+"'";
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test_01", "T3sxl00");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);) {
			if(rset.next()) {
				shopMember.setMemberId(rset.getString("MEMBER_ID"));
				shopMember.setMemberPw(rset.getString("MEMBER_PW"));
				shopMember.setPhone(rset.getString("PHONE"));
				shopMember.setGender(rset.getString("GENDER").toCharArray()[0]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopMember;
	}
}