package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void status() {
		System.out.println(
				"TV[channel=" + channel + 
				", volume="+ volume + 
				", power=" + power + "]"
				);
	}

	public void power(boolean on) {
		if(on)
			this.power = true;
		else
			this.power = false;
	}

	public void volume(int vol) {
		if(vol >= 100) {
			this.volume = 0;
		}
		else if (vol <= 0) {
			this.volume = 100;
		}
		else {
			this.volume = vol;
		}
	}
	
	public void volume(boolean up) {
		if(up)
			this.volume += 1;
		else
			this.volume -= 1;
		
		volume(this.volume);
	}

	public void channel(int channel) {
	    if(channel >= 256){
	        this.channel = 1;
	    }
	    else if(channel <= 0) {
	    	this.channel = 255 ;	    	
	    }
	}
	
	public void channel(boolean up) {
		if(up)
			this.channel += 1;
		else
			this.channel -= 1;
		
		channel(this.channel);
	}
	
}