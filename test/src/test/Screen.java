package test;

public class Screen implements ScreenSpec {
	
	String Resolution;
	int refreshRate;
	int responseTime;
	
	public Screen(String Resolution, int refreshRate, int responseTime) {
		this.Resolution = Resolution;
		this.refreshRate = refreshRate;
		this.responseTime= responseTime;
	}

	@Override
	public String getResolution() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRefreshRate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResponseTime() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 public String toString() {
		
		return "Resolution: " + Resolution + "\n" + "Refresh Rate " + refreshRate + "\n" + "Resposnse time " + responseTime;
	 }

}
