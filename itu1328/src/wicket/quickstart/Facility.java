package wicket.quickstart;

public class Facility {
	private Integer FacilityId;
	private String FacilityInfo;
	private Integer BranchId;

	public Facility(Integer FacId, String Info, Integer BranchId){
		this.FacilityId = FacId;
		this.FacilityInfo = Info;
		this.BranchId = BranchId;
	}
	
	//setter methods
	public void setFacilityId(Integer Id){
		this.FacilityId = Id;
	}
	public void setFacilityInfo(String Info){
		this.FacilityInfo = Info;
	}
	public void setBranchId(Integer BranchId){
		this.BranchId = BranchId;
	}
	
	//getter methods
	
	public Integer getFacilityID(){
		return this.FacilityId;
	}
	public Integer getBranchID(){
		return this.BranchId;
	}
	
	public String getFacilityInfo(){
		return this.FacilityInfo;
	}
	

}
