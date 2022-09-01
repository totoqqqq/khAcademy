package day016;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Connect {
	/*URL = oracle link, driver=oracle driver
	 id = oracle ���Ǳ����ִ� id, password = �ش� ���̵��� password*/
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE",DRIVER="oracle.jdbc.driver.OracleDriver";
	private String id="mini", password="admin";
	private Connection con;
	Connect(){
		try {
			Class.forName(DRIVER);
			this.con=DriverManager.getConnection(this.URL, this.id, this.password);
//			System.out.println("oracle success");
		}catch(ClassNotFoundException e) {
			System.out.println("jdbc loading fail");
		}catch(SQLException e) {
			System.out.println("oracle loading fail");
		}
	}
	PreparedStatement pstmt(String sqlOrder) {/*PreparedStatement �ܺο��� ���*/
		try {
			return this.con.prepareCall(sqlOrder);
		} catch (SQLException e) {
			System.out.println("sql ���� �Է� �����Դϴ�.");
			e.printStackTrace();
			return null;
		}
	}
	void commit() {
		try {
			this.con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}