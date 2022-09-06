package day020;

public class KHDTO {
	private int pid, price;
	private String pname;
	private boolean iced;
	KHDTO(int pid, String pname, int price, boolean iced){
		this.pid=pid;
		this.pname=pname;
		this.price=price;
		this.iced=iced;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public boolean isIced() {
		return iced;
	}
	public void setIced(boolean iced) {
		this.iced = iced;
	}
}
