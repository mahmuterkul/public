package wicket.quickstart;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;
import java.util.LinkedList;


public class CustomerCollectionJDBC implements ICustomerCollection{
	private Connection _db;
	
	public CustomerCollectionJDBC(String dbFilePath){
		try{
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
	
	public List<Customer> getCustomers(){
		List<Customer> custList = new LinkedList<Customer>();
		try{
			String query = "SELECT ID,CUSTNAME,CUSTCONTACT,CUSTMAIL,CUSTPASSWORD FROM TBLCUSTOMER";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while(results.next()){
				Integer ID = results.getInt("ID");
				String custName = results.getString("CUSTNAME");
				String custInfo = results.getString("CUSTCONTACT");
				String custMail = results.getString("CUSTMAIL");
				String custPass = results.getString("CUSTPASSWORD");
				Customer _newCustomer = new Customer(ID, custName, custInfo, custMail, custPass);
				custList.add(_newCustomer);
			}
			results.close();
			statement.close();
		}catch(SQLException ex){
			System.out.print("ex.toString()");
		}
		return custList;
	}
	
	public void addCustomer(Customer _newCustomer){
		try{
			String query = "INSERT INTO TBLCUSTOMER ID,CUSTNAME,CUSTCONTACT,CUSTMAIL,CUSTPASSWORD VALUES(?,?,?,?,?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _newCustomer.getCustID());
			statement.setString(2, _newCustomer.getCustName());
			statement.setString(3, _newCustomer.getCustInfo());
			statement.setString(4, _newCustomer.getCustMail());
			statement.setString(5, _newCustomer.getCustPass());
			statement.executeUpdate();
		}catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	
	public void deleteCustomer(Customer _customer){
		try{
			String query = "DELETE FROM TABLE WHERE(ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1,_customer.getCustID());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	public void updateCustomer(Customer _customer){
		try{
			String query = "UPDATE TBLCUSTOMER SET ID=?, CUSTNAME=?, CUSTCONTACT=?, CUSTMAIL=?, CUSTPASSWORD=? WHERE(ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _customer.getCustID());
			statement.setString(2, _customer.getCustName());
			statement.setString(3, _customer.getCustInfo());
			statement.setString(4, _customer.getCustMail());
			statement.setString(5, _customer.getCustPass());
			statement.executeUpdate();
			statement.close();
		}catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
}