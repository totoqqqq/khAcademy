package day018_client;

//server = ���� ������, client = ���񽺸� ���� �޴���
//IP = Internet Protocol; IP(Address)v4 = ff.ff.ff.ff ;v6 �غ���. IP Address = ��Ʈ��ũ�� �ܸ��� �ĺ��� ���� �ּ�.
//Port = ���ͳ� ��� ������ HW,service,process �ĺ��� �� ����.0~1024 = well known port �ַ� ���� ��Ʈ�̸�, �浹 ������ ���� ���ؾߵǴ� ��Ʈ.
//TCP = Transmission Control Protocol(Internet Protocol) ��� ǥ�� �Ծ�; ���� ������ ���; 1:1 ����,�ִ� �ּҰ� �ƴҽ� UDP ���� ��żӵ� ����, �ŷڼ� �ִ� ����������, �������� ���� ����� ���� ����
//UDP = User Datagram Protocol ��� ǥ�� �Ծ�; �񿬰� ���� ���; ���� ���ϴ� �׸��� ���, �ӵ� ����, ������ ���� �Ұ�. ������ �߽�.
//Socket = ��Ʈ��ũ ���α׷��� ��� ������ ���� ���� �ܸ���. ��Ʈ��ũ ���α׷� ������ ���Ḹ�� ���.
//Stream = ��ü �� �����͸� �ְ� �޴� ���.
public class Run {
	public static void main(String[] args) {
		new Client();
//		new TCPClient();
	}
}