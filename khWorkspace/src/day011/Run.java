package day011;

public class Run {
	public static void main(String[] args) {
//		Monitor moni = new Monitor();
		TV tv = new TV();
		tv.ChannelDown();
		tv.ViewChannel();
		tv.ChannelUp();
		tv.ViewChannel();
		tv.VolumeUp();
		tv.ViewVolume();
		tv.VolumeDown();
		tv.ViewVolume();
	}
}