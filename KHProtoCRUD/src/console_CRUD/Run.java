package console_CRUD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String ID, PW="", checkPW="", ename; 
		int phone; 
		main:while(true) {
			System.out.println("====================\n사설 BBS(컨셉)\n====================\n메뉴를 선택해주세요.\n1.전화걸기(연결)\n2.권한획득(가입)\n나머지.종료");
			switch(scan.nextLine()) {
			case "1":
				System.out.println("아이디를 입력해주세요.");
				ID=scan.nextLine();
				System.out.println("암호를 입력해주세요.");
				PW=scan.nextLine();
				Client clientLogin = new Controller().login(new Client(ID,PW));
				if(clientLogin==null) {
					System.out.println("ID, PW를 확인해주세요.");
					continue;
				}
				else
					System.out.println(clientLogin.getNickname()+"님 환영합니다.");
					BBS:while(true) {
						String title,content;
						System.out.println(clientLogin.getNickname()+"님 메뉴를 선택해주세요.\n1.새 글 작성 2.게시판 읽기 3.작성 글 수정 4. 작성 글 삭제 5. 본인 정보 수정 6. 회원 탈퇴 \n[메뉴 이외 선택하면 종료] ");
						if(clientLogin.getLevels()==10)
							System.out.println("[관리자 메누]\n101.게시글 삭제, 102. 회원 권한 수정/정지/해제");
						switch(scan.nextLine()) {
						case "1":
							System.out.println("글 제목을 입력해주세요.");
							title=scan.nextLine();
							System.out.println("글 내용을 입력해주세요.");
							content=scan.nextLine();
							Noticeboard cCreateCheck =new Controller().createContent(new Noticeboard(title,content,clientLogin.getID()));
							if(cCreateCheck==null)
								System.out.println("게시글 작성에 실패했습니다.");
							else
								System.out.println(cCreateCheck.getTitle()+" 게시글 작성에 성공하였습니다.");
							break;
						case "2":
							String searchKey=null;
							System.out.print("게시글 전체를 보시겠습니까?\n아니면 검색 할 키워드를 입력해주세요.(미입력시 전체조회) : ");
							searchKey=scan.nextLine();
							System.out.println("전체 게시글 목록\n글 번호\t | 제목\t\t | 작성자\t\t | 작성일\t");
							ArrayList<Noticeboard> nbs = new Controller().readContent();
							if(nbs.size()==0)
								System.out.println("BBS에 작성된 게시글이 없습니다.");
							else {
								if(searchKey.equals("")) {
									for(Noticeboard nb:nbs) {
										System.out.printf("%s\t | %s\t | %s\t | %s\n",(nb.getNewChars()?nb.getNo()+"☆new":nb.getNo()),nb.getTitle(),(nb.getEname()==null?"탈퇴한 회원":nb.getEname()),nb.getTimeFormat());
									}
								}else {
									for(Iterator<Noticeboard> nb=nbs.iterator();nb.hasNext();) {
										Noticeboard keyWord = nb.next();
										if(keyWord.getTitle().contains(searchKey)||(keyWord.getEname().contains(searchKey)))
											System.out.printf("%s\t | %s\t | %s\t | %s\n",(keyWord.getNewChars()?keyWord.getNo()+"☆new":keyWord.getNo()),keyWord.getTitle(),(keyWord.getEname()==null?"탈퇴한 회원":keyWord.getEname()),keyWord.getTimeFormat());
										else
											nb.remove();
									}
								}
								if(nbs.size()==0) {
									System.out.println("검색결과가 없습니다.(메인으로)");
									continue;
								}
								System.out.println("읽을 게시글 번호를 입력해주세요. 없는 번호 입력시 메뉴로");
								int selectNo=0;
								try {
									selectNo = Integer.parseInt(scan.nextLine());
								}catch(NumberFormatException e) {
									break;
								}
								for(Noticeboard nb:nbs) {
									if(selectNo == nb.getNo()) {
										System.out.println("==================================================\n"+nb.getTitle() + "\n==================================================\n"+nb.getContent()+"\n==================================================");
										break;
									}
								}
								System.out.println("메인 메뉴로 돌아갑니다.");
							}
							break;
						case "3":
							System.out.println("전체 게시글 목록\n 글 번호\t | 제목\t\t | 작성자\t\t | 작성일\t");
							ArrayList<Noticeboard> nbsu = new Controller().readContent();
							if(nbsu.size()==0)
								System.out.println("BBS에 검색된 게시글이 없습니다.");
							else {
								for(Noticeboard nb:nbsu) {
									if(nb.getID().equals(clientLogin.getID()))
									System.out.printf("%s\t | %s\t | %s\t | %s\n",(nb.getNewChars()?nb.getNo()+"☆new":nb.getNo()),nb.getTitle(),nb.getEname(),nb.getTimeFormat());
								}
								System.out.println("수정할 게시글 번호를 입력해주세요. 없는 번호 입력시 메뉴로");
								int selectNo=0;
								try {
									selectNo = Integer.parseInt(scan.nextLine());
								}catch(NumberFormatException e) {
									break;
								}
								Noticeboard mbUp=new Controller().editSearchContent(selectNo,clientLogin);
								if(!(mbUp==null)) {
									System.out.println("수정할 글 제목을 입력하세요.");
									title=scan.nextLine();
									System.out.println("수정할 내용을 입력하세요.");
									content=scan.nextLine();
									Noticeboard check=new Controller().updateNB(new Noticeboard(selectNo,title,content,mbUp.getID()));
									if(!(check==null))
										System.out.println(title + "게시글을 수정완료 하셨습니다.");
									else
										System.out.println(title + "게시글을 수정실패 하셨습니다.");
								}
								System.out.println("메인 메뉴로 돌아갑니다.");
							}
							break;
						case "4":
							System.out.println("전체 게시글 목록\n 글 번호\t | 제목\t\t | 작성자\t\t | 작성일\t");
							ArrayList<Noticeboard> nbsd = new Controller().readContent();
							if(nbsd.size()==0)
								System.out.println("BBS에 검색된 게시글이 없습니다.");
							else {
								for(Noticeboard nb:nbsd) {
									if(nb.getID().equals(clientLogin.getID()))
									System.out.printf("%s\t | %s\t | %s\t | %s\n",(nb.getNewChars()?nb.getNo()+"☆new":nb.getNo()),nb.getTitle(),nb.getEname(),nb.getTimeFormat());
								}
								System.out.println("삭제할 게시글 번호를 입력해주세요. 없는 번호 입력시 메뉴로");
								int selectNo=0;
								try {
									selectNo = Integer.parseInt(scan.nextLine());
								}catch(NumberFormatException e) {
									break;
								}
								Noticeboard mbDe=new Controller().editSearchContent(selectNo,clientLogin);
								if(!(mbDe==null)) {
									Noticeboard check=new Controller().deleteNB(new Noticeboard(selectNo,mbDe.getTitle(),mbDe.getContent(),mbDe.getID()));
									if(!(check==null))
										System.out.println(mbDe.getTitle() + "게시글을 삭제완료 하셨습니다.");
									else
										System.out.println(mbDe.getTitle() + "게시글을 삭제실패 하였습니다.");
								}
								System.out.println("메인 메뉴로 돌아갑니다.");
							}
							break;
						case "5":
							String upEname=null, upPW=null; 
							int upPhone=0;
							System.out.println("[개인정보 변경]-미입력시 이전정보 유지합니다.");
							System.out.println("수정 할 암호를 작성해주세요.");
							upPW=scan.nextLine();
							if(upPW.equals(""))
								upPW=clientLogin.getPW();
							System.out.println("수정 할 닉네임을 작성해주세요.");
							upEname=scan.nextLine();
							if(upEname.equals(""))
								upEname=clientLogin.getNickname();
							System.out.println("수정 할 전화번호를 작성해주세요.");
							try {
							upPhone = Integer.parseInt(scan.nextLine());
							}catch(NumberFormatException e) {
								upPhone=clientLogin.getPhone();
							}
							Client check=new Controller().updateSign(new Client(clientLogin.getID(),upPW,upEname,upPhone,clientLogin.getLevels()));
							if(!(check==null)) {
								System.out.println(check.getNickname()+"님 정보가 변경 되었습니다.");
								break BBS;
							}
							else
								System.out.println(clientLogin.getNickname()+"님 정보가 변경 실패 하였습니다.(휴대전화 확인 부탁드립니다.)");
							break;
						case "6":
							System.out.println("계정을 삭제하시겠습니까?(Y/N)-이외 선택시 N");
							switch(scan.nextLine()) {
							case "Y":
								new Controller().deleteSign(clientLogin);
								System.out.println(clientLogin.getNickname()+"님 그동안 감사했습니다. 회원 탈퇴 되었습니다.");
								break BBS;
							case "N":
							default:
								System.out.println(clientLogin.getNickname()+"회원 탈퇴 취소 되었습니다.");
								break;
							}
							break;
						case "101":
							if(clientLogin.getLevels()==10) {
								String deleteKey;
								System.out.println("삭제할 게시글 KeyWord(글 제목,ID)를 입력해주세요. 미입력시 전체 삭제");
								deleteKey=scan.nextLine();
								boolean checkDeAdmin=new Controller().deleteNBAd(deleteKey);
								if(checkDeAdmin)
									System.out.println(deleteKey+"가 포함된 게시물들이 일괄 삭제 되었습니다.");
								else
									System.out.println("삭제 오류가 발생되었습니다.");
								break;
							}
						case "102":
							if(clientLogin.getLevels()==10) {
								System.out.println("내일 구현 할래");
								break;
							}
						default:
							System.out.println("BBS 연결을 종료 합니다.");
							break BBS;				
						}
					}
				break;
			case "2":
				System.out.println("회원 가입을 시작합니다.(장시간 고민시 통화료가 아픕니다.)");
				System.out.println("ID를 입력해주세요.");
				ID=scan.nextLine();
				while(!(PW.equals(checkPW)&&!(checkPW.equals("")))) {
					System.out.println("PW를 입력해주세요.");
					PW=scan.nextLine();
					System.out.println("입력했던 PW를 한번더 입력해주세요.");
					checkPW=scan.nextLine();
					if(PW.equals(checkPW)&&!(PW.equals("")))
						break;
					System.out.println("패스워드를 확인해주세요.");
				}
				System.out.println("사용할 닉네임을 작성해주세요.");
				ename=scan.nextLine();
				System.out.println("휴대전화번호를 작성해주세요.");
				phone=Integer.parseInt(scan.nextLine());
				Client clientSignup = new Controller().signup(new Client(ID,PW,ename,phone,1));
				if(clientSignup==null)
					System.out.println("회원 가입에 실패하였습니다. 정보와 휴대전화번호 중복을 확인해주세요.");
				else
					System.out.println(clientSignup.getNickname()+"님 가입을 환영합니다. 로그인 해주세요.");
				break;
			default:
				break main;
			}
		}
		System.out.println("프로그램 종료");
	}
}