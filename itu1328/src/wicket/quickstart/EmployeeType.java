package wicket.quickstart;

public class EmployeeType {
	private Integer empID;
	private String empName;
	private String empInfo;
	
	//  constructor
	public EmployeeType(Integer empID, String empName, String empInfo){
		this.empID = empID;
		this.empName = empName;
		this.empInfo = empInfo;
	}
	
	//  setter methods
	
	public void setEmpID(Integer empID){
		this.empID = empID;
	}
	
	public void setEmpName(String empName){
		this.empName = empName;
	}
	
	public void setEmpInfo(String empInfo){
		this.empInfo = empInfo;
	}
	
	// getter methods
	
	public Integer getEmpID(){
		return empID;
	}
	
	public String getEmpName(){
		return empName;
	}
	
	public String getEmpInfo(){
		return empInfo;
	}
}
