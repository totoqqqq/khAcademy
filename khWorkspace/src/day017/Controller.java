package day017;

import java.sql.ResultSet;
import java.sql.SQLException;

class Controller {
	void createInput(String id,String name,int kor,int eng,int math) {
		new StudentDAO().CreateStudent(new StudentDTO(id,name,kor,eng,math));
	}
	void readInput(String selectType ,String searchStr) {
		new StudentDAO().readStudent(selectType,searchStr);
	}
	void updateInput(String updateStr){
		new StudentDAO().updateStudent(updateStr);
	}
	void deleteInput(String dedateStr){
		new StudentDAO().deleteStudent(dedateStr);
	}
	 void viewResultSet(ResultSet rs) {
		 System.out.println("학번\t\t이름\t국어\t영어\t수학\t합계\t평균");
		 try {
			while(rs.next())
				 System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),(rs.getInt(3)+rs.getInt(4)+rs.getInt(5)),(rs.getInt(3)+rs.getInt(4)+rs.getInt(5))/(double)3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}