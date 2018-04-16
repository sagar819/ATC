package CreateReportTrial1;

import java.util.Date;

public class CDPojojTrial1 {

	
	public String TSString;
	public String AirCraftID;
	public Double Xpos;
	public Double Ypos;
	@Override
	public String toString() {
		return "CDPojoj [TSString=" + TSString + ", AirCraftID=" + AirCraftID + ", Xpos=" + Xpos + ", Ypos=" + Ypos
				+ ", TSDate=" + TSDate + "]";
	}
	public Date TSDate;
	public String getTSString() {
		return TSString;
	}
	public void setTSString(String tSString) {
		TSString = tSString;
	}
	public String getAirCraftID() {
		return AirCraftID;
	}
	public void setAirCraftID(String airCraftID) {
		AirCraftID = airCraftID;
	}
	
	public Double getXpos() {
		return Xpos;
	}
	public void setXpos(Double xpos) {
		Xpos = xpos;
	}
	
	public Double getYpos() {
		return Ypos;
	}
	public void setYpos(Double ypos) {
		Ypos = ypos;
	}
	public Date getTSDate() {
		return TSDate;
	}
	public void setTSDate(Date tSDate) {
		TSDate = tSDate;
	}
	
	
}
