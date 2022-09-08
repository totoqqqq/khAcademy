package console_CRUD;

import java.util.ArrayList;

public class Controller {
	private static Controller cont=null;
	private Controller() {	
	}
	public static Controller getInstance() {
		if(cont==null)
			cont=new Controller();
		return cont;
	}
	Client login(Client cli) {
		ClientDAO cliDAO = ClientDAO.getInstance();
		return cliDAO.login(cli);
	}
	Client signup(Client cli) {
		ClientDAO cliDAO = ClientDAO.getInstance();
		return cliDAO.signup(cli);
	}
	Noticeboard createContent(Noticeboard nb) {
		NoticeboardDAO nbDAO=NoticeboardDAO.getInstance();
		return nbDAO.createContent(nb);
	}
	ArrayList<Noticeboard> readContent() {
		NoticeboardDAO nbDAO=NoticeboardDAO.getInstance();
		return nbDAO.readContent();
	}
	Noticeboard editSearchContent(int i,Client clientLogin) {
		NoticeboardDAO nbDAO=NoticeboardDAO.getInstance();
		return nbDAO.editSearchContent(i,clientLogin);
	}
	public Noticeboard updateNB(Noticeboard nb) {
		NoticeboardDAO nbDAO=NoticeboardDAO.getInstance();
		return nbDAO.updateContent(nb);
	}
	public Noticeboard deleteNB(Noticeboard nb) {
		NoticeboardDAO nbDAO=NoticeboardDAO.getInstance();
		return nbDAO.deleteContent(nb);
	}
	public Client updateSign(Client cli) {
		ClientDAO cliDAO = ClientDAO.getInstance();
		return cliDAO.updateSign(cli);
	}
	public Client deleteSign(Client cli) {
		ClientDAO cliDAO = ClientDAO.getInstance();
		return cliDAO.deleteSign(cli);
	}
	public boolean deleteNBAd(String deleteKey) {
		NoticeboardDAO nbDAO=NoticeboardDAO.getInstance();
		return nbDAO.deleteContentAD(deleteKey);
	}
}