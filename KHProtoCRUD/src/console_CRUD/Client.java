package console_CRUD;

public class Client {
	private String ID,PW,nickname;
	private int phone,levels;
	Client(String ID, String PW, String nickname, int phone, int levels){
		this.ID=ID;
		this.PW=PW;
		this.nickname=nickname;
		this.phone=phone;
		this.levels=levels;
	}
	Client(String ID, String PW){
		this.ID=ID;
		this.PW=PW;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
}