package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ActivityCollectionJDBC implements IActivityCollection {
	private Connection _db;

	public ActivityCollectionJDBC(String dbFilePath) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}

		try {
			String jdbcURL = "jdbc:sqlite:" + dbFilePath;
			this._db = DriverManager.getConnection(jdbcURL);
		} catch (SQLException ex) {
			throw new UnsupportedOperationException(ex.getMessage());
		}
	}

	public List<Activity> getActivities() {
		List<Activity> activities = new LinkedList<Activity>();
		try {
			String query = "SELECT ID,ACTTITLE, ACTINFO, ACTSTARTHOUR, ACTENDHOUR, BRANCHID FROM TBLACTIVITY";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				Integer id = results.getInt("ID");
				String title = results.getString("ACTTITLE");
				String info = results.getString("ACTINFO");
				String startHour = results.getString("ACTSTARTHOUR");
				String endHour = results.getString("ACTENDHOUR");
				Integer branchId = results.getInt("BRANCHID");
				Activity activity = new Activity(id, title, info, startHour,
						endHour, branchId);
				activities.add(activity);
			}
			results.close();
			statement.close();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
		return activities;
	}

	public void addActivity(Activity activity) {
		try {
			String query = "INSERT INTO TBLACTIVITY (ACTTITLE,ACTINFO,ACTSTARTHOUR,ACTENDHOUR,BRANCHID) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setString(1, activity.getTitle());
			statement.setString(2, activity.getInfo());
			statement.setString(3, activity.getStartHour());
			statement.setString(4, activity.getEndHour());
			statement.setInt(5, activity.getBranchId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
	}

	public void deleteActivity(Activity activity) {
		try {
			String query = "DELETE FROM TBLACTIVITY WHERE (ID = ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, activity.getId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
	}

	public void updateActivity(Activity activity) {
		try {
			String query = "UPDATE TBLACTIVITY SET ACTTITLE = ?, ACTINFO = ?,ACTSTARTHOUR = ?,ACTENDHOUR = ?,BRANCHID = ?  WHERE (ID = ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setString(1, activity.getTitle());
			statement.setString(2, activity.getInfo());
			statement.setString(3, activity.getStartHour());
			statement.setString(4, activity.getEndHour());
			statement.setInt(5, activity.getBranchId());
			statement.setInt(6, activity.getId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
	}

}