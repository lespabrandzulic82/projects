package test;


public class AudioPlayer extends Product implements MultimediaControl {

	String audioSpecification;
	ItemType mediaType;
	 
	
	public AudioPlayer(String name, String audioSpecification) {
		super(name);
		this.audioSpecification = audioSpecification;
		mediaType = ItemType.AU;
	}

	@Override
	public void play() {
		
		System.out.println("Playing audio...");
		

	}

	@Override
	public void stop() {
		System.out.println("Stoping");
		

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
		return x + "\n" + "Audio specification: " + audioSpecification + "\n" + "media type " + mediaType.value();
	}
		
	

}
