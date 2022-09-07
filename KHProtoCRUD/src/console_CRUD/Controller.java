package console_CRUD;

import java.util.ArrayList;

public class Controller {
	Client login(Client cli) {
		return new ClientDAO().login(cli);
	}
	Client signup(Client cli) {
		return new ClientDAO().signup(cli);
	}
	Noticeboard createContent(Noticeboard nb) {
		return new NoticeboardDAO().createContent(nb);
	}
	ArrayList<Noticeboard> readContent() {
		return new NoticeboardDAO().readContent();
	}
	Noticeboard editSearchContent(int i,Client clientLogin) {
		return new NoticeboardDAO().editSearchContent(i,clientLogin);
	}
	public Noticeboard updateNB(Noticeboard nb) {
		return new NoticeboardDAO().updateContent(nb);
	}
	public Noticeboard deleteNB(Noticeboard nb) {
		return new NoticeboardDAO().deleteContent(nb);
	}
	public Client updateSign(Client cli) {
		return new ClientDAO().updateSign(cli);
	}
}