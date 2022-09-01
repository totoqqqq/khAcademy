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
		//에러1 String, String, String 형 생성자에 대하여 정의하지 않았습니다.
		emps[2]=new Employee("1003","Mike","13000");
		
		System.out.println("ID\tNAME\tWAGE");
		System.out.println("-------------------------");
		//에러2 for문 조건이 (i<4) 으로 NullPoniterException emps[3]를 정의하지 않아 NULL 상태에서 값을 불러오기 시도 했습니다.
		for(int i=0;i<emps.length;i++) {
			//에러2 해결책 NullPointerException 발생 시 저장 된 값의 대한 불러오기가 끝난 걸로 보고 break; 시켜 for문을 종료 시킵니다.
			try {
			System.out.println(emps[i].getEmp_id()+"\t"+emps[i].getEmp_name()+"\t"+emps[i].getWage());}
			catch(NullPointerException e) {
				break;
			}
		}
	}
}