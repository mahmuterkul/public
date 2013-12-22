package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class EmployeeCollectionJDBC implements IEmployeeCollection{

	private Connection _db;
	
	public EmployeeCollectionJDBC(String dbFilePath){
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			System.out.print(ex.toString());
		}
		try {
			String jdbcURL = "jdbc:sqlite:" + dbFilePath;
			this._db = DriverManager.getConnection(jdbcURL);
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
		
		public List<Employee> getEmployees(){
			List<Employee> empList = new LinkedList<Employee>();
			try {
				String query = "SELECT FROM TBLEMPLOYEE (ID,EMPNAME,EMPCONTACT,EMPMAIL,EMPPASSWORD,EMPTYPE)";
				Statement statement = this._db.createStatement();
				ResultSet results = statement.executeQuery(query);
				
				while(results.next()){
					Integer ID = results.getInt("ID");
					String empName = results.getString("EMPNAME");
					String empContact = results.getString("EMPCONTACT");
					String empMail = results.getString("EMPMAIL");
					String empPass = results.getString("EMPPASSWORD");
					Integer empType = results.getInt("EMPTYPE");
					Employee _newEmployee = new Employee(ID,empName,empContact,empMail,empPass,empType);
					empList.add(_newEmployee);
				}
				results.close();
				statement.close();
			}catch (SQLException ex) {
				System.out.print(ex.toString());
			}
			return empList;
		}
		
		public void addEmployee(Employee _newEmployee){
			try{
				String query = "INSERT INTO TBLEMPLOYEE (EMPNAME,EMPCONTACT,EMPMAIL,EMPPASSWORD,EMPTYPE VALUES(?,?,?,?,?))";
				PreparedStatement statement = this._db.prepareStatement(query);
				
				statement.setString(1, _newEmployee.getEmpName());
				statement.setString(2, _newEmployee.getEmpInfo());
				statement.setString(3, _newEmployee.getEmpMail());
				statement.setString(4, _newEmployee.getEmpPass());
				statement.setInt(5,_newEmployee.getEmpType());
				statement.executeUpdate();
			}catch (SQLException ex) {
				System.out.print(ex.toString());
			}
		}
		
		public void deleteEmployee(Employee _employee){
			try {
				String query = "DELETE FROM TBLEMPLOYEE WHERE (ID=?)";
				PreparedStatement statement = this._db.prepareStatement(query);
				statement.setInt(1, _employee.getEmpID());
				statement.executeUpdate();
				statement.close();

			} catch (SQLException ex) {
				System.out.print(ex.toString());
			}
		}
		
		public void updateEmployee(Employee _employee){
			try{
				String query = "UPDATE TBLEMPLOYEE SET ID=?, EMPNAME=?, EMPINFO=?, EMPMAIL=?, EMPPASSWORD=?, EMPTYPE=? WHERE(ID=?)";
				PreparedStatement statement = this._db.prepareStatement(query);
				statement.setInt(1, _employee.getEmpID());
				statement.setString(2, _employee.getEmpName());
				statement.setString(3, _employee.getEmpInfo());
				statement.setString(4, _employee.getEmpMail());
				statement.setString(5, _employee.getEmpPass());
				statement.setInt(6,_employee.getEmpType());
				statement.executeUpdate();
				statement.close();
			} catch (SQLException ex) {
				System.out.print(ex.toString());
			}
		}
		
	}
















