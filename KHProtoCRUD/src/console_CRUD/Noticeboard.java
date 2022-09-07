package console_CRUD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Noticeboard {
	private String title, content, ID;
	private int no;
	private String writeDate;
	private String ename;
	Noticeboard(int no, String title, String content, String ID, String writeDate, String ename){
		this.no=no;
		this.title=title;
		this.content=content;
		this.ID=ID;
		this.writeDate=writeDate;
		this.ename=ename;
	}
	Noticeboard(int no, String title, String content, String ID, String writeDate){
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
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/DD");
		this.writeDate=sdf.format(new Date().getTime());
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
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}