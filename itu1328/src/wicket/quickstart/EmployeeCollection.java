package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;
public class EmployeeCollection implements IEmployeeCollection {
	private List<Employee>_empList;
	
	public EmployeeCollection(){
		this._empList = new LinkedList<Employee>();
	}
	
	public List<Employee> getEmployees() {
		return this._empList;
	}

	public void addEmployee(Employee item) {
		this._empList.add(item);
	}

	public void deleteEmployee(Employee item) {
		this._empList.remove(item);
	}

	public void updateEmployee(Employee item) {
		//this._empList.update(item);
	}
}
