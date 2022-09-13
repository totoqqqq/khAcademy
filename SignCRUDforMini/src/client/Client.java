package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import server.SignMember;

class Client{
	final String HOMEIP= "172.28.128.1", TESTIP="192.168.150.32", PORT="25000";
	Client(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try(Socket server = new Socket();){
			server.connect(new InetSocketAddress(HOMEIP, Integer.parseInt(PORT)));
			try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(server.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			OutputStream os = server.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);){
				String inputMassage=null;
				inputMassage=br.readLine();
				main:while(true) {
					if(inputMassage!=null&&!inputMassage.equals("")) {
						switch(inputMassage){
						case "#main":
							System.out.println("==========회원관리 시스템==========\n1. 로그인\n2. 회원가입");
 							break;
						case "#login":
							SignMember sm = new SignMember();
							System.out.println("아이디를 입력해주세요.");
							sm.setSign_id(scan.nextLine());
							System.out.println("암호를 입력해주세요.");
							sm.setSign_pw(scan.nextLine());
							oos.writeObject(sm);
							oos.flush();
							inputMassage=br.readLine();
							while(true) {
								if(inputMassage!=null&&!inputMassage.equals("")) {
									if(inputMassage.equals("#true"))
										System.out.println(sm.getSign_id()+"님 로그인에 성공하였습니다.(Login success)");
									else
										System.out.println("로그인에 실패하였습니다.(please check ID&PW)");
									inputMassage=br.readLine();
									continue main;
								}
								inputMassage=br.readLine();
							}
						case "#signup":
							SignMember suSm = new SignMember();
							System.out.println("아이디를 입력해주세요.");
							suSm.setSign_id(scan.nextLine());
							System.out.println("암호를 입력해주세요.");
							suSm.setSign_pw(scan.nextLine());
							System.out.println("닉네임을 입력해주세요.");
							suSm.setNickname(scan.nextLine());
							System.out.println("휴대전화번호를 입력해주세요.");
							suSm.setPhone(Integer.parseInt(scan.nextLine()));
							oos.writeObject(suSm);
							oos.flush();
							inputMassage=br.readLine();
							while(true) {
								if(inputMassage!=null&&!inputMassage.equals("")) {
									if(inputMassage.equals("#true"))
										System.out.println(suSm.getNickname()+"님 회원가입에 성공하였습니다.(please Login)");
									else
										System.out.println("회원가입에 실패하였습니다.(please check ID,PW,etc...)");
									inputMassage=br.readLine();
									continue main;
								}
								inputMassage=br.readLine();
							}
						}
						inputMassage=null;
					}
					else {
						pw.println(scan.nextLine());
						pw.flush();
						inputMassage=br.readLine();
					}
				}
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}