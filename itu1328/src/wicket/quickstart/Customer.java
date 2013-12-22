package wicket.quickstart;

import java.io.Serializable;

public class Customer implements Serializable{
	private Integer custID;
	private String custName;
	private String custInfo;
	private String custMail;
	private String custPass;
	
	//constructor
	public Customer(Integer custID, String custName, String custInfo, String custMail, String CustPass){
		this.custID = custID;
		this.custInfo = custInfo;
		this.custMail = custMail;
		this.custName = custMail;
		this.custPass = custPass;
		
	}

// setter methods
	
	public Customer() {
		this.custID = null;
		this.custInfo = null;
		this.custMail = null;
		this.custName = null;
		this.custPass = null;
	}

	public void setCustID(Integer custId){
		this.custID = custId;
	}
	
	public void setCustName(String custName){
		this.custName = custName;
	}
	
	public void setCustInfo(String custInfo){
		this.custInfo = custInfo;
	}
	
	public void setCustMail(String custMail){
		this.custMail = custMail;
	}
	
	public void setCustPass(String custPass){
		this.custPass = custPass;
	}
	
	//  getter methods
	
	public Integer getCustID(){
		return this.custID;
	}
	
	public String getCustName(){
		return this.custName;
	}
	
	public String getCustInfo(){
		return this.custInfo;
	}
	
	public String getCustMail(){
		return this.custMail;
	}
	
	public String getCustPass(){
		return this.custPass;
	}
	
	
}
