package day021_test06;

public class Run {
	public static void main(String[] args) {
		ShopMember sm=new ShopMemberDAO().searchUser("admin");
		System.out.println("검색어 : admin\n검색된 아이디 : "+sm.getMemberId()+"\n검색된 휴대전화번호 : "+sm.getPhone()+"\n검색된 성별 : "+sm.getGender());
	}
}
