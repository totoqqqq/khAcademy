package day020;

import java.util.ArrayList;

public class Controller {
	void insert(KHDTO input) {
		new KHDAO().insert(input);
	}
	ArrayList<KHDTO> search(String search) {
		ArrayList<KHDTO> rs=new KHDAO().select(search);
		return rs;
	}
}
