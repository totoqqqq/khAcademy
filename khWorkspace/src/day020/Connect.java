package day020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

class Connect{
	private final String DBID="kh",DBPW="kh",DBURL="jdbc:oracle:thin:@localhost:1521:XE", DBDRIVER="oracle.jdbc.driver.OracleDriver";
	private Connection con;
	private OracleConnectionPoolDataSource ocpds;
	Connect(){
		try {
			Class.forName(DBDRIVER);
			this.ocpds = new OracleConnectionPoolDataSource();
			ocpds.setURL(DBURL);
			ocpds.setUser(DBID);
			ocpds.setPassword(DBPW);
			PooledConnection pc = ocpds.getPooledConnection();
			this.con=pc.getConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
	}
	PreparedStatement pstmt(String sql){
		try {
			return this.con.prepareCall(sql);
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류");
			e.printStackTrace();
			return null;
		}
	}
	void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
}
