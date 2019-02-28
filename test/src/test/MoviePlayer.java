package test;

public class MoviePlayer extends Product implements MultimediaControl {

	public String screen;
	MonitorType monitorType;
	
	public MoviePlayer(String name,String screen) {
		super(name);
		this.screen = screen;
		monitorType = MonitorType.LED; 
	
	}

	@Override
	public void play() {
		
		System.out.println("Playing movie...");
	}

	@Override
	public void stop() {
		
		System.out.println("Stop");
	}

	@Override
	public void previous() {
		
		System.out.println("Previous");
	}

	@Override
	public void next() {
		
		System.out.println("Next");
	}
	
	@Override
	public String toString() {
		String x = super.toString();
		return x + "\n" + "Screen:" + screen + "\n" + "Monitor type: " + monitorType ;
	}

}
