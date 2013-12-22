package wicket.quickstart;

public class Reporting {
	private Integer Id;
	private Integer CustomerId;
	private Integer EmployeeId;
	private String StartDate;
	private String EndDate;
	private Integer BranchId;

	public Reporting(Integer Id, Integer CustomerId, Integer EmployeeId,
			String StartDate, String EndDate, Integer BranchId) {
		this.Id = Id;
		this.CustomerId = CustomerId;
		this.EmployeeId = EmployeeId;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.BranchId = BranchId;
	}

	// Setters
	public void setId(Integer id) {
		this.Id = id;
	}

	public void setCustomerId(Integer CustomerId) {
		this.CustomerId = CustomerId;
	}

	public void setEmployeeId(Integer EmployeeId) {
		this.EmployeeId = EmployeeId;
	}

	public void setStartDate(String StartDate) {
		this.StartDate = StartDate;
	}

	public void setEndDate(String EndDate) {
		this.EndDate = EndDate;
	}

	public void setBranch(Integer id) {
		this.BranchId = id;
	}

	// Setters
	// Getters
	public Integer getId() {
		return this.Id;
	}

	public Integer getCustomerId() {
		return this.CustomerId;
	}

	public Integer getEmployeeId() {
		return this.EmployeeId;
	}

	public String getStartDate() {
		return this.StartDate;
	}

	public String getEndDate() {
		return this.EndDate;
	}

	public Integer getBranch() {
		return this.BranchId;
	}
	// Getters
}
