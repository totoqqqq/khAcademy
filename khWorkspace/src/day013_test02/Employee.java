package day013_test02;

public class Employee {
	private String emp_id;
	private String emp_name;
	private int wage;//�ñ�
	
	public Employee() {
		
	}
	public Employee(String emp_id, String emp_name, int wage) {
		this.setEmp_id(emp_id);
		this.setEmp_name(emp_name);
		this.setWage(wage);
	}
	//����1 �ذ�å String, String, String �� �����ڿ� ���Ͽ� �����մϴ�.
	public Employee(String emp_id, String emp_name, String wage) {
		this.setEmp_id(emp_id);
		this.setEmp_name(emp_name);
		try {
		this.setWage(Integer.parseInt(wage));
		}catch(NumberFormatException e) {
				System.out.println("wage ���� ���ڷ� �ٽ� �������ּ���");
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
		//����3 �ν��Ͻ����� wage ������ �������� �����ϴ�.(���ú��� = ���ú���) 
//		wage = wage;
		//����3 �ذ�å �ν��Ͻ� ������ ���� setter �޼ҵ带 �ùٸ��� �����մϴ�.
		this.wage = wage;
	}
}