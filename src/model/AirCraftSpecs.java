package model;

import java.util.Date;

public class AirCraftSpecs {

	private String AirCraftName;
	private String Status;
	private Date AcceptedTime;
	public String getAirCraftName() {
		return AirCraftName;
	}
	public void setAirCraftName(String airCraftName) {
		AirCraftName = airCraftName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getAcceptedTime() {
		return AcceptedTime;
	}
	public void setAcceptedTime(Date acceptedTime) {
		AcceptedTime = acceptedTime;
	}
	@Override
	public String toString() {
		return "AirCraftSpecs [AirCraftName=" + AirCraftName + ", Status=" + Status + ", AcceptedTime=" + AcceptedTime
				+ "]";
	}
	
}
