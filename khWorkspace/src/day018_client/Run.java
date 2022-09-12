package day018_client;

//server = 서비스 제공자, client = 서비스를 제공 받는자
//IP = Internet Protocol; IP(Address)v4 = ff.ff.ff.ff ;v6 준비중. IP Address = 네트워크상 단말기 식별용 고유 주소.
//Port = 인터넷 통신 종단점 HW,service,process 식별용 논리 단위.0~1024 = well known port 주로 쓰인 포트이며, 충돌 방지를 위해 피해야되는 포트.
//TCP = Transmission Control Protocol(Internet Protocol) 통신 표준 규약; 연결 지향적 통신; 1:1 연결,최단 주소가 아닐시 UDP 보다 통신속도 느림, 신뢰성 있는 데이터전송, 검증으로 인한 상대적 성능 저하
//UDP = User Datagram Protocol 통신 표준 규약; 비연결 지향 통신; 소위 말하는 그리드 방식, 속도 빠름, 데이터 검증 불가. 성능을 중시.
//Socket = 네트워크 프로그램의 통신 수행을 위한 논리적 단말기. 네트워크 프로그램 끼리의 연결만을 담당.
//Stream = 객체 간 데이터를 주고 받는 통로.
public class Run {
	public static void main(String[] args) {
		new Client();
//		new TCPClient();
	}
}