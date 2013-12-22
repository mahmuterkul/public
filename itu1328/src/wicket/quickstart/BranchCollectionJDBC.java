package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BranchCollectionJDBC implements IBranchCollection {

		private Connection _db;
		
		public BranchCollectionJDBC(String dbFilePath){
			
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
		
		public List<Branch> getBranchs(){
			
			List<Branch> branchList = new LinkedList<Branch>();
			try{
				
				String query =  "SELECT ID,BRANCHNAME,BRANCHADDRESS,BRANCHPHONE FROM TBLBRANCH";
				Statement statement = this._db.createStatement();
				ResultSet results = statement.executeQuery(query);
				
				while(results.next()){
					Integer ID = results.getInt("ID");
					String branchName = results.getString("BRANCHNAME");
					String branchAddress = results.getString("BRANCHADDRESS");
					String branchPhone = results.getString("BRANCHPHONE");
					Branch _newBranch = new Branch(ID,branchName,branchAddress,branchPhone);
					branchList.add(_newBranch);
				}
				
				results.close();
				statement.close();
				
			}
			catch (SQLException ex) {
				System.out.print(ex.toString());
			}
			
			return branchList;
		}
		
		public void addBranch(Branch _newBranch){
			try{
				String query = "INSERT INTO TBLBRANCH (BRANCHNAME,BRANCHADDRESS,BRANCHPHONE) VALUES(?,?,?)";
				PreparedStatement statement = this._db.prepareStatement(query);
				
				statement.setString(1, _newBranch.getBranchName());
				statement.setString(2, _newBranch.getBranchAddress());
				statement.setString(3, _newBranch.getBranchPhone());
				statement.executeUpdate();
			}
			catch (SQLException ex) {
				System.out.print(ex.toString());
			}
		}
		
		public void deleteBranch(Branch _branch){
			try {
				String query = "DELETE FROM TBLEMPLOYEE WHERE (ID=?)";
				PreparedStatement statement = this._db.prepareStatement(query);
				statement.setInt(1, _branch.getBranchID());
				statement.executeUpdate();
				statement.close();

			} 
			catch (SQLException ex) {
				System.out.print(ex.toString());
			}
		}
		
		public void updateBranch(Branch _branch){
			try{
				String query = "UPDATE TBLEMPLOYEE SET ID=?, BRANCHNAME=?, BRANCHADDRESS=?, BRANCHPHONE=? WHERE(ID=?)";
				PreparedStatement statement = this._db.prepareStatement(query);
				statement.setInt(1, _branch.getBranchID());
				statement.setString(2, _branch.getBranchName());
				statement.setString(3, _branch.getBranchAddress());
				statement.setString(4, _branch.getBranchPhone());
				
				statement.executeUpdate();
				statement.close();
			} 
			catch (SQLException ex) {
				System.out.print(ex.toString());
			}
		}
				
}
