package day017;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import oracle.jdbc.datasource.impl.OracleConnectionPoolDataSource;


class Connect {
	/*URL = oracle link, driver=oracle driver
	 id = oracle ���Ǳ����ִ� id, password = �ش� ���̵��� password*/
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE",DRIVER="oracle.jdbc.driver.OracleDriver";
	private String id="mini", password="admin";
	private Connection con;
	private OracleConnectionPoolDataSource conp;
	Connect(){
		try {
			Class.forName(DRIVER);
			this.conp=new OracleConnectionPoolDataSource();
			conp.setURL(this.URL);
			conp.setUser(this.id);
			conp.setPassword(this.password);
			PooledConnection pc = conp.getPooledConnection();
			this.con=pc.getConnection();
			
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