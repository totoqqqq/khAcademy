package day021_test06;

public class Run {
	public static void main(String[] args) {
		ShopMember sm=new ShopMemberDAO().searchUser("admin");
		System.out.println("�˻��� : admin\n�˻��� ���̵� : "+sm.getMemberId()+"\n�˻��� �޴���ȭ��ȣ : "+sm.getPhone()+"\n�˻��� ���� : "+sm.getGender());
	}
}
