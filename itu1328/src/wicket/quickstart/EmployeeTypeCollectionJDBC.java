package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.LinkedList;
public class EmployeeTypeCollectionJDBC {
	private Connection _db;
	
	public EmployeeTypeCollectionJDBC(String dbFilePath){
		
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
	
	public List<EmployeeType> getEmployeeType(){
		List<EmployeeType> typeList = new LinkedList<EmployeeType>();
		try{
			String query = "SELECT FROM TBLEMPLOYEETYPE ID,EMPTYPENAME,EMPTYPEINFO";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while(results.next()){
				Integer ID = results.getInt("ID");
				String empTypeName = results.getString("EMPTYPENAME");
				String empTypeInfo = results.getString("EMPTYPEINFO");
				EmployeeType _newType = new EmployeeType(ID, empTypeName, empTypeInfo);
				typeList.add(_newType);
			}
		results.close();
		statement.close();
		}catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return typeList;
	}
	
	public void addEmployeeType(EmployeeType _newType){
		try{
			String query = "INSERT INTO TBLEMPLOYEETYPE (ID,EMPTYPENAME,EMPTYPEINFO)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1,_newType.getEmpID());
			statement.setString(2, _newType.getEmpName());
			statement.setString(3, _newType.getEmpInfo());
			statement.executeUpdate();
			statement.close();
		}
		catch (SQLException ex){
			System.out.print(ex.toString());
		}
	}
	
	public void deleteEmployeeType(EmployeeType _Type){
		try{
			String query = "DELETE FROM TBLEMPLOYEETYPE WHERE(ID = ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _Type.getEmpID());
			statement.executeUpdate();
			statement.close();
		}catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	
	public void updateEmployeeType(EmployeeType _Type){
		try{
			String query = "UPDATE TBLEMPLOYEETYPE SET ID=?, EMPTYPENAME=?,EMPTYPEINFO=?";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _Type.getEmpID());
			statement.setString(2, _Type.getEmpName());
			statement.setString(3, _Type.getEmpInfo());
			statement.executeUpdate();
			statement.close();
		}catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	
}
