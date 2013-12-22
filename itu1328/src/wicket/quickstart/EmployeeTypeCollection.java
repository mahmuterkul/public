package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;
public class EmployeeTypeCollection implements IEmployeeTypeCollection{
	private List<EmployeeType>_empType;
	
	public EmployeeTypeCollection(){
		this._empType = new LinkedList<EmployeeType>();
	}
	
	public List<EmployeeType> getEmployeeType() {
		return this._empType;
	}

	public void addEmployeeType(EmployeeType item) {
		this._empType.add(item);
	}

	public void deleteEmployeeType(EmployeeType item) {
		this._empType.remove(item);
	}

	public void updateEmployeeType(EmployeeType item) {
		//this._empType.update(item);
	}
}
