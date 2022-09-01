package day014_Quiz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class FTP {
	private FTPClient client = new FTPClient();
	final private String UPLOADPATH="d:\\FTP\\upload",DOWNLOADPATH="D:\\FTP\\download";
	Scanner scan = new Scanner(System.in);
	public void MainMenu() {
		int selectMenu;
		while(true) {
			System.out.println("\n=== FTP Client Program ===\n1. Connect FTP Server\n2. Exit Program");
			selectMenu=(int)NumCheck();
			switch(selectMenu) {
			case 1:
				LoginInput();
				break;
			case 2:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("�޴��� �ٽ� �������ּ���.");
				break;
			}
		}
	}
	
	void LoginInput() {
		FTPConnection();
		FTPLogin();
		FTPMenu();
	}
	
	void FTPMenu() {
		int selectMenu;
		while(true) {
			System.out.println("\n====================\n1. Upload File\n2. Download File\n3. Disconnect FTP Server\n4. Delete File");
			selectMenu=(int)NumCheck();
			switch(selectMenu) {
			case 1:
				UploadFile();
				break;
			case 2:
				DownloadFile();
				break;
			case 3:
				DisconnectFTP();
				break;
			case 4:
				DeleteFile();
				break;
			default:
				System.out.println("�޴��� �ٽ� �������ּ���.");
				break;
			}
		}
	}
	
	FTPFile[] ViewFileList() {
		FTPFile[] files;
		try {
			files = client.list();
			if(files.length==0) {
				System.out.println("������ ����� ������ �����ϴ�.");
				return null;
			}
			System.out.println("[View] You Can Download List.");
			for(FTPFile i:files) {
				System.out.printf("name : %s, type : %s, size : %dByte, modifiedDate = %s\n",i.getName(),(i.getType()==1?"DIRECTORY":"FILE"),i.getSize(),i.getModifiedDate());
			}
			return files;
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
				| FTPDataTransferException | FTPAbortedException | FTPListParseException e) {
			System.out.println("���� Ȯ�� ����");
			e.printStackTrace();
			return null;
		}
	}
	
	void UploadFile(){
		String selectFile;
		File dir = new File(UPLOADPATH);
		File[] fileList;
		fileList=dir.listFiles();
		if(fileList.length==0) {
			System.out.println("���ε� ������ ����� ������ �����ϴ�.");
			return;
		}
		for(File i:fileList) {
			System.out.printf("name : %s\n",i.getName());
		}
		upfile:while(true) {
			selectFile=scan.nextLine();
			for(File i:fileList) {
				if(i.getName().equals(selectFile)) {
					try {
						client.upload(i);
					} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
							| FTPDataTransferException | FTPAbortedException e) {
						e.printStackTrace();
						System.out.println("���ε� ����");
					}
					break upfile;
				}
			}
			System.out.println("���ϸ��� �ٽ� �Է����ּ���.");
		}
		
	}
	
	void DownloadFile() {
		String selectFile;
		FTPFile[] files;
		files=ViewFileList();
		if(files.equals(null))
			return;
		while(true) {
			selectFile=scan.nextLine();
			for(FTPFile i:files) {
				if(i.getName().equals(selectFile)) {
					try {
						client.download(selectFile, new File((DOWNLOADPATH+"\\"+selectFile)));
						return;
					} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
							| FTPDataTransferException | FTPAbortedException e) {
						System.out.println("�ٿ�ε� ����");
						e.printStackTrace();
					}
				}
			}
			System.out.println("���ϸ��� ����� �Է����ּ���.");
		}
	}
	
	void DisconnectFTP() {
		try {
			client.disconnect(true);
			System.exit(1);;
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			e.printStackTrace();
		}
	}
	
	void DeleteFile() {
		String selectFile;
		FTPFile[] files;
		files=ViewFileList();
		if(files.equals(null))
			return;
		while(true) {
			selectFile=scan.nextLine();
			for(FTPFile i:files) {
				if(i.getName().equals(selectFile)) {
					try {
						client.deleteFile(selectFile);
						return;
					} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
						try {
							client.deleteDirectory(selectFile);
							return;
						} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e1) {
							System.out.println("���� ���� ����");
							e1.printStackTrace();
						}
					}
				}
			}
			System.out.println("���ϸ��� ����� �Է����ּ���.");
		}
		
	}

	void FTPLogin() {
		String id,password;
		while(true) {
			System.out.println("input id");
			id=scan.nextLine();
			System.out.println("input password");
			password=scan.nextLine();
			try {
				client.login(id, password);
			} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
				System.out.println("Check ID & Password");
			}
			if(client.isPassive()==true) {
				System.out.println("Login Success!");
				return;
			}
		}
	}
	
	void FTPConnection() {
		String address,port;
		while(true) {
			System.out.println("input url");
			address=scan.nextLine();
			System.out.println("input port");
			port=Float.toString(NumCheck());
			try {
				client.connect(address,(int)Float.parseFloat(port));
			} catch (NumberFormatException | IllegalStateException | IOException | FTPIllegalReplyException
					| FTPException e) {
				System.out.println("Check URL & Port");
			}
			if(client.isConnected()==true) {
				System.out.println("Connection Success!");
				return;
			}
		}
	}

	float NumCheck() {
		float number=Float.parseFloat(scan.nextLine());
		while(true) {
			try {
				return number;
			}
			catch(NumberFormatException e){
				System.out.println("[�Է¿���]���ڸ� �Է����ּ���.");
				number=Float.parseFloat(scan.nextLine());
			}
		}
	}
}