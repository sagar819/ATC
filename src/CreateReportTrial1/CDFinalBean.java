package CreateReportTrial1;

public class CDFinalBean {

	
	private String AirCraft1;
	private String AirCraft2;
	private String timestamp;
	public String getAirCraft1() {
		return AirCraft1;
	}
	public void setAirCraft1(String airCraft1) {
		AirCraft1 = airCraft1;
	}
	public String getAirCraft2() {
		return AirCraft2;
	}
	public void setAirCraft2(String airCraft2) {
		AirCraft2 = airCraft2;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "CDFinalBean [AirCraft1=" + AirCraft1 + ", AirCraft2=" + AirCraft2 + ", timestamp=" + timestamp + "]";
	}
	
}
