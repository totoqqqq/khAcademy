package day011;

class Monitor {
	protected String brand;
	protected int price;
	protected double weight;
	final private int MAXVOLUME = 100, MINVOLUME = 0;
	private int volume=MINVOLUME;
	Monitor(){
		
	}
	
	Monitor(String brand, int price, double weight){
		this.brand=brand;
		this.price=price;
		this.weight=weight;
	}
	
	void PowerOn() {
		
	}
	
	void PowerOff() {
		
	}
	
	void VolumeUp() {
		if(volume<MAXVOLUME)
			this.volume++;
	}
	
	void VolumeDown() {
		if(volume>MINVOLUME)
			this.volume--;
	}
	void ViewVolume() {
		int volume = this.volume;
		System.out.println(volume);
	}
}

class TV extends Monitor{
	final private int MAXCHANNEL = 1000, MINCHANNEL = 1;
	private int channel=MINCHANNEL;
	TV(){
		
	}
	
	TV(String brand, int price, double weight){
		this.brand=brand;
		this.price=price;
		this.weight=weight;
	}
	
	void ChannelUp() {
		if(this.channel<MAXCHANNEL)
			this.channel++;
		else
			this.channel=MINCHANNEL;
	}
	
	void ChannelDown() {
		if(this.channel>MINCHANNEL)
			this.channel--;
		else
			this.channel=MAXCHANNEL;
	}
	
	void ViewChannel() {
		int channel = this.channel;
		System.out.println(channel);
	}
}
