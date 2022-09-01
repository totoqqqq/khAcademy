package day013_test02;

public class Employee {
	private String emp_id;
	private String emp_name;
	private int wage;//시급
	
	public Employee() {
		
	}
	public Employee(String emp_id, String emp_name, int wage) {
		this.setEmp_id(emp_id);
		this.setEmp_name(emp_name);
		this.setWage(wage);
	}
	//에러1 해결책 String, String, String 형 생성자에 대하여 정의합니다.
	public Employee(String emp_id, String emp_name, String wage) {
		this.setEmp_id(emp_id);
		this.setEmp_name(emp_name);
		try {
		this.setWage(Integer.parseInt(wage));
		}catch(NumberFormatException e) {
				System.out.println("wage 값을 숫자로 다시 정의해주세요");
				System.exit(1);
		}
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		//에러3 인스턴스변수 wage 에대한 변동값이 없습니다.(로컬변수 = 로컬변수) 
//		wage = wage;
		//에러3 해결책 인스턴스 변수에 대한 setter 메소드를 올바르게 정의합니다.
		this.wage = wage;
	}
}