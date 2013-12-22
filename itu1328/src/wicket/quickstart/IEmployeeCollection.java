package wicket.quickstart;

import java.util.List;
public interface IEmployeeCollection {
	public List<Employee> getEmployees();
	
	public void addEmployee(Employee item);
	
	public void deleteEmployee(Employee item);
	
	public void updateEmployee(Employee item);
}
