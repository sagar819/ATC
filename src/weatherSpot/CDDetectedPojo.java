package weatherSpot;

public class CDDetectedPojo {

	public String TS1String;
	public String TS2String;
	public String AirCraftID1;
	public String AirCraftID2;
	private double distance;
	public String getTSString() {
		return TS1String;
	}
	public void setTS1String(String tSString) {
		TS1String = tSString;
	}
	public String getAirCraftID1() {
		return AirCraftID1;
	}
	public void setAirCraftID1(String airCraftID1) {
		AirCraftID1 = airCraftID1;
	}
	public String getAirCraftID2() {
		return AirCraftID2;
	}
	public void setAirCraftID2(String airCraftID2) {
		AirCraftID2 = airCraftID2;
	}
	@Override
	public String toString() {
		return "CDDetectedPojo [TS1String=" + TS1String + ", TS2String=" + TS2String + ", AirCraftID1=" + AirCraftID1
				+ ", AirCraftID2=" + AirCraftID2 + ", distance=" + distance + "]";
	}
	public double getDistance() {
		return distance;
	}
	public String getTS2String() {
		return TS2String;
	}
	public void setTS2String(String tS2String) {
		TS2String = tS2String;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
