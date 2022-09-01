package day013_test02;

public class Main {
	public static void main(String[] args) {
		Employee e1 = new Employee("1001","Jane",11000);
		Employee e2 = new Employee();
		
		e2.setEmp_id("1002");
		e2.setEmp_name("Tom");
		e2.setWage(9000);
		Employee[] emps = new Employee[4];
		emps[0]=e1;
		emps[1]=e2;
		//����1 String, String, String �� �����ڿ� ���Ͽ� �������� �ʾҽ��ϴ�.
		emps[2]=new Employee("1003","Mike","13000");
		
		System.out.println("ID\tNAME\tWAGE");
		System.out.println("-------------------------");
		//����2 for�� ������ (i<4) ���� NullPoniterException emps[3]�� �������� �ʾ� NULL ���¿��� ���� �ҷ����� �õ� �߽��ϴ�.
		for(int i=0;i<emps.length;i++) {
			//����2 �ذ�å NullPointerException �߻� �� ���� �� ���� ���� �ҷ����Ⱑ ���� �ɷ� ���� break; ���� for���� ���� ��ŵ�ϴ�.
			try {
			System.out.println(emps[i].getEmp_id()+"\t"+emps[i].getEmp_name()+"\t"+emps[i].getWage());}
			catch(NullPointerException e) {
				break;
			}
		}
	}
}