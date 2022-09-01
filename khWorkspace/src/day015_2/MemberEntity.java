package day015_2;

import java.util.ArrayList;

class MemberEntity {
	private static ArrayList<MemberDTO> memberDB = new ArrayList<MemberDTO>();
	public void addMemberDB(MemberDTO mem){
		memberDB.add(mem);
	}
	public ArrayList<MemberDTO> getMemberDB() {
		return memberDB;
	}
}