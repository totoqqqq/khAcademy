package day018homework;

import java.util.ArrayList;

class Manager {
	private ArrayList<Account> acc = new ArrayList<Account>();
	Manager(){
		acc.add(new Account("test1","test1"));
		acc.add(new Account("test2","test2"));
	}
	void add(Account ac) {
		this.acc.add(ac);
	} 
}
