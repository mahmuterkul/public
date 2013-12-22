package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class FacilityCollectionJDBC implements IFacilityCollection {

	private Connection _db;

	public FacilityCollectionJDBC(String dbFilePath) {

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

	public List<Facility> getFacilities() {

		List<Facility> facilityList = new LinkedList<Facility>();

		try {

			String query = "SELECT ID, FACINFO, BRANCHID FROM TBLFACILITY";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				Integer ID = results.getInt("ID");
				String FacInfo = results.getString("FACINFO");
				Integer BranchId = results.getInt("BRANCHID");
				Facility _newFacility = new Facility(ID, FacInfo, BranchId);
				facilityList.add(_newFacility);
			}

			results.close();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return facilityList;
	}

	public void addFacility(Facility _newfacility) {
		try {
			String query = "INSERT INTO TBLFACILITY (FACINFO,BRANCHID VALUES(?,?,?))";
			PreparedStatement statement = this._db.prepareStatement(query);
			//statement.setInt(1, _newfacility.getFacilityID());
			statement.setString(1, _newfacility.getFacilityInfo());
			statement.setInt(2, _newfacility.getBranchID());
			statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}

	}

	public void deleteFacility(Facility _facility) {
		try {
			String query = "DELETE FROM TBLFACILITY WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _facility.getFacilityID());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void updateFacility(Facility _facility) {
		try {
			String query = "UPDATE TBLFACILITY SET ID=?, FACILITYINFO=?, BRANCHID=? WHERE(ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _facility.getFacilityID());
			statement.setString(2, _facility.getFacilityInfo());
			statement.setInt(3, _facility.getBranchID());

			statement.executeUpdate();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public List<Facility> getSpecificFacilities(double id) {

		List<Facility> facilityList = new LinkedList<Facility>();

		try {

			String query = "SELECT ID, FACINFO, BRANCHID FROM TBLFACILITY WHERE (BRANCHID="
					+ (int) id + ")";
			Statement statement = this._db.prepareStatement(query);
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				Integer ID = results.getInt("ID");
				String FacInfo = results.getString("FACINFO");
				Integer BranchId = results.getInt("BRANCHID");
				Facility _newFacility = new Facility(ID, FacInfo, BranchId);
				facilityList.add(_newFacility);
			}

			results.close();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return facilityList;
	}

}
