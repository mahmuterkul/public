package wicket.quickstart;

import java.util.List;
public interface IEmployeeTypeCollection {
	public List<EmployeeType> getEmployeeType();
	
	public void addEmployeeType(EmployeeType item);
	
	public void deleteEmployeeType(EmployeeType item);
	
	public void updateEmployeeType(EmployeeType item);
}
