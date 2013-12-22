package wicket.quickstart;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable{
	private Integer ID;
	private Integer custID;
	private Integer branchID;
	private Integer roomNo;
	private Integer roomType;
	private String startDate;
	private String endDate;
	
	// constructor
	
	public Reservation(Integer ID, Integer custID, Integer branchID, Integer roomNo, Integer roomType, String startDate, String endDate){
		this.ID = ID;
		this.custID = custID;
		this.branchID = branchID;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Reservation(Integer ID, Integer roomNo, String startDate,
			String endDate) {
		this.ID = ID;
		this.roomNo = roomNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Reservation(){
		
	}
	
	// setter methods
	


	public void setID(Integer ID){
		this.ID = ID;
	}
	
	public void setCustID(Integer custId){
		this.custID = custId;
	}
	
	public void setBranchID(Integer branchId){
		this.branchID = branchId;
	}
	
	public void setRoomNo(Integer roomNo){
		this.roomNo = roomNo;
	}
	
	public void setRoomType(Integer roomType){
		this.roomType = roomType;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
	// getter methods
	
	public Integer getCustID(){
		return this.custID;
	}
	
	public Integer getBranchID(){
		return this.branchID;
	}
	
	public Integer getRoomNo(){
		return this.roomNo;
	}
	
	public Integer getRoomType(){
		return this.roomType;
	}
	
	public String getStartDate(){
		return this.startDate;
	}
	
	public String getEndDate(){
		return this.endDate;
	}

	public Integer getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}
}
