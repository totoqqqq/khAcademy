package console_CRUD;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Noticeboard {
	private String title, content, ID;
	private int no;
	private Timestamp writeDate;
	private String ename;
	Noticeboard(int no, String title, String content, String ID, Timestamp writeDate, String ename){
		this.no=no;
		this.title=title;
		this.content=content;
		this.ID=ID;
		this.writeDate=writeDate;
		this.ename=ename;
	}
	Noticeboard(int no, String title, String content, String ID, Timestamp writeDate){
		this.no=no;
		this.title=title;
		this.content=content;
		this.ID=ID;
		this.writeDate=writeDate;
	}
	Noticeboard(int no, String title, String content, String ID){
		this.no=no;
		this.title=title;
		this.content=content;
		this.ID=ID;
		this.writeDate=new Timestamp(System.currentTimeMillis());
	}
	Noticeboard(String title, String content,String ID){
		this.title=title;
		this.content=content;
		this.ID=ID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getTimeFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd a hh:mm:ss");
		String time = sdf.format(writeDate);
		return time;
	}
	public boolean getNewChars() {
		if(((System.currentTimeMillis()-this.writeDate.getTime())/1000)<86400)
			return true;
		return false;
	}
}