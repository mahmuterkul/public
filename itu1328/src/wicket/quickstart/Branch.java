package wicket.quickstart;

import java.io.Serializable;

public class Branch implements Serializable{
	private Integer BranchId;
	private String  BranchName;
	private String  BranchAddress;
	private String BranchPhone;

	public Branch(Integer Id, String Name, String Address, String Phone){
		
		this.BranchId = Id;
		this.BranchName = Name;
		this.BranchAddress = Address;
		this.BranchPhone = Phone;
	}
	
	//public Branch(){
		
	//}
	
	//setter methods
	public void setBranchId(Integer Id){
		this.BranchId = Id;
	}
	public void setBranchName(String Name){
		this.BranchName = Name;
	}
	public void setBranchAddress(String Address){
		this.BranchAddress = Address;
	}
	public void setBranchPhone(String Phone){
		this.BranchPhone = Phone;
	}
	
	//getter methods
	public Integer getBranchID(){
		return this.BranchId;
	}
	public String getBranchName(){
		return this.BranchName;
	}
	public String getBranchAddress(){
		return this.BranchAddress;
	}
	public String getBranchPhone(){
		return this.BranchPhone;
	}
	
}
	