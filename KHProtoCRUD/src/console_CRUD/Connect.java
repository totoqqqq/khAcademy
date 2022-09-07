package console_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class Connect {
	private final String ID="commu", PW="commu";
	private final String DBURL="jdbc:oracle:thin:@localhost:1521:xe",DBdriver="oracle.jdbc.driver.OracleDriver";
	private Connection con;
	private OracleConnectionPoolDataSource ocpds;
	Connect(){
		try {
			Class.forName(DBdriver);
			this.ocpds=new OracleConnectionPoolDataSource();
			ocpds.setURL(DBURL);
			ocpds.setUser(ID);
			ocpds.setPassword(PW);
			PooledConnection pc = ocpds.getPooledConnection();
			this.con=pc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오라클 호출 실패");
			e.printStackTrace();
		}
	}
	PreparedStatement pstmt(String sql) {
		try {
			return this.con.prepareCall(sql);
		} catch (SQLException e) {
			System.out.println("sql 구문 오류");
			e.printStackTrace();
			return null;
		}
	}
	void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("풀 반환 오류");
			e.printStackTrace();
		}
	}
}