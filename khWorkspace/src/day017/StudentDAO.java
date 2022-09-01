package day017;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class StudentDAO {
	void CreateStudent(StudentDTO dto){
		Connect con = new Connect();
		PreparedStatement stuData = con.pstmt("insert into schoolexam values(?,?,?,?,?,?)");
		try {
			stuData.setString(1, dto.getId());
			stuData.setString(2, dto.getName());
			stuData.setInt(3, dto.getKor());
			stuData.setInt(4, dto.getEng());
			stuData.setInt(5, dto.getMath());
			stuData.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			stuData.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}
	void readStudent(String selectType, String searchStr) {
		Connect con = new Connect();
		try {
			ResultSet rs = con.pstmt("select * from schoolexam where "+(selectType.equals("kor") ?selectType+" > "+Integer.parseInt(searchStr):selectType.equals("eng") ?selectType+" > "+Integer.parseInt(searchStr):selectType.equals("math") ?selectType+" > "+Integer.parseInt(searchStr):selectType+" like '%"+searchStr+"%'")).executeQuery();
			new Controller().viewResultSet(rs);
			con.close();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
	 void readStudent() {
		 Connect con = new Connect();
		 try {
			ResultSet rs=con.pstmt("select * from schoolexam order by id").executeQuery();
			new Controller().viewResultSet(rs);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void updateStudent(String updateStr) {
		Connect con = new Connect();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try {
			ResultSet rs = con.pstmt("select * from schoolexam where id='"+updateStr+"' OR name='"+updateStr+"'").executeQuery();
			if(rs.next()==false) {
				System.out.println("검색값이 없습니다.");
				return;
			}
			PreparedStatement upReport = con.pstmt("update schoolexam set kor=?,eng=?,math=? where id='"+updateStr+"' OR name='"+updateStr+"'");
			String[] tag = {"국어","영어","수학"};
			for(int i=0;i<tag.length;i++) {
				System.out.print(tag[i]+"점수를 입력해주세요. : ");
				upReport.setInt(i+1, Integer.parseInt(scan.nextLine()));
			}
			upReport.execute();
			System.out.println(rs.getString(2)+" 님의 정보가 수정되었습니다.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void deleteStudent(String dedateStr) {
		Connect con = new Connect();
		try {
			ResultSet rs = con.pstmt("select * from schoolexam where id='"+dedateStr+"' OR name='"+dedateStr+"'").executeQuery();
			if(rs.next()==false) {
				System.out.println("검색값이 없습니다.");
				return;
			}
			con.pstmt("delete from schoolexam where id='"+dedateStr+"' OR name='"+dedateStr+"'").execute();
			System.out.println(rs.getString(2)+" 님의 정보가 삭제되었습니다.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}