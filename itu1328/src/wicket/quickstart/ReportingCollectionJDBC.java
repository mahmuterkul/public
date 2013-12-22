package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ReportingCollectionJDBC implements IReportingCollection {
	private Connection _db;

	public ReportingCollectionJDBC(String dbFilePath) {

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

	public List<Reporting> getReports() {
		List<Reporting> reportList = new LinkedList<Reporting>();
		try {
			String query = "SELECT ID, CUSTOMERID, EMPLOYEEID,STARTDATE,ENDDATE,BRANCHID FROM TBLREPORTING";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				Integer id = results.getInt("ID");
				Integer customerId = results.getInt("CUSTOMERID");
				Integer employeeId = results.getInt("EMPLOYEEID");
				String startDate = results.getString("STARTDATE");
				String endDate = results.getString("ENDDATE");
				Integer branchId = results.getInt("BRANCHID");
				Reporting _newReport = new Reporting(id, customerId,
						employeeId, startDate, endDate, branchId);
				reportList.add(_newReport);
			}
			results.close();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return reportList;
	}

	public void addReport(Reporting _newReport) {
		try {
			String query = "INSERT INTO TBLREPORTING (CUSTOMERID, EMPLOYEEID,STARTDATE,ENDDATE,BRANCHID) VALUES (?, ?,?,?,?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _newReport.getCustomerId());
			statement.setInt(2, _newReport.getEmployeeId());
			statement.setString(3, _newReport.getStartDate());
			statement.setString(4, _newReport.getEndDate());
			statement.setInt(5, _newReport.getBranch());
			statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void deleteReport(Reporting _report) {
		try {
			String query = "DELETE FROM TBLREPORTING WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _report.getId());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void updateReport(Reporting _report) {
		try {
			String query = "UPDATE TBLREPORTING SET CUSTOMERID=?,EMPLOYEEID=? , STARTDATE=?,ENDDATE=?,BRANCHID=? WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _report.getCustomerId());
			statement.setInt(2, _report.getEmployeeId());
			statement.setString(3, _report.getStartDate());
			statement.setString(4, _report.getEndDate());
			statement.setInt(5, _report.getBranch());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
}
