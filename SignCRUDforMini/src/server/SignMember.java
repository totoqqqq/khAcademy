package server;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignMember implements Serializable{
	private static final long serialVersionUID = 10000L;
	//직렬화
	private String sign_id, sign_pw, nickname;
	private int phone, sign_no, member_lv;
	public SignMember(){
		
	}
	public SignMember(String sign_id, String sign_pw, String nickname, int phone){
		this.sign_id=sign_id;
		this.sign_pw = encrypt(sign_pw);
		this.nickname=nickname;
		this.phone=phone;
	}
	
	public String getSign_id() {
		return sign_id;
	}
	public void setSign_id(String sign_id) {
		this.sign_id = sign_id;
	}
	public String getSign_pw() {
		return sign_pw;
	}
	public void setSign_pw(String sign_pw) {
		this.sign_pw = encrypt(sign_pw);
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
	public int getSign_no() {
		return sign_no;
	}
	public void setSign_no(int sign_no) {
		this.sign_no = sign_no;
	}
	public int getMember_lv() {
		return member_lv;
	}
	public void setMember_lv(int member_lv) {
		this.member_lv = member_lv;
	}
	private String encrypt(String sign_pw) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(sign_pw.getBytes());
			return byteToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	private String byteToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for(byte b:bytes) 
			builder.append(String.format("%02x", b));
		return builder.toString();
	}
}