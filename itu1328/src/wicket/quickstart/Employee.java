package wicket.quickstart;

public class Employee {
	private Integer empID;
	private String empName;
	private String empInfo;
	private String empMail;
	private String empPass;
	private Integer empType;
	
	public Employee()
	{}
	public Employee(Integer empID, String empName, String empInfo, String empMail,
			String empPass, Integer empType){
		this.empID = empID;
		this.empName = empName;
		this.empInfo = empInfo;
		this.empMail = empMail;
		this.empPass = empPass;
		this.empType = empType;
	}
	
	// setter methods
	
	public void setEmpID(Integer empID){
		this.empID = empID;
	}
	
	public void setEmpName(String empName){
		this.empName = empName;
	}
	
	public void setEmpInfo(String empInfo){
		this.empInfo = empInfo;
	}
	
	public void setEmpMail(String empMail){
		this.empMail = empMail;
	}
	
	public void setEmpPass(String empPass){
		this.empPass = empPass;
	}
	
	public void setEmpType(Integer empType){
		this.empType = empType;
	}
	
	// getter methods
	
	public Integer getEmpID(){
		return this.empID;
	}
	
	public String getEmpName(){
		return this.empName;
	}
	
	public String getEmpInfo(){
		return this.empInfo;
	}
	
	public String getEmpMail(){
		return this.empMail;
	}
	
	public String getEmpPass(){
		return this.empPass;
	}
	
	public Integer getEmpType(){
		return this.empType;
	}
}