package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class RoomType {
	private Integer Id;
	private String RoomTypeName;
	private String RoomTypeInfo;
	public Connection _db;

	public RoomType() {

	}

	public RoomType(Integer Id, String Name, String Info) {
		this.Id = Id;
		this.RoomTypeName = Name;
		this.RoomTypeInfo = Info;
	}

	// Getters
	public Integer getRoomTypeId() {
		return this.Id;
	}

	public String getRoomTypeName() {
		return this.RoomTypeName;
	}

	public String getRoomTypeInfo() {
		return this.RoomTypeInfo;
	}

	// Getters
	public void RoomTypeCollectionJDBC(String dbFilePath) {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			System.out.print(ex.toString());
		}
		try {
			String jdbcURL = "jdbc:sqlite:" + dbFilePath;
			this._db = DriverManager.getConnection(jdbcURL);
			System.out.print("path : " + dbFilePath);
			System.out.print("url :  " + jdbcURL);
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public List<RoomType> getRoomTypes() {
		List<RoomType> roomTypeList = new LinkedList<RoomType>();
		try {
			String query = "SELECT ID, ROOMTYPENAME, ROOMTYPEINFO FROM TBLROOMTYPE";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				Integer id = results.getInt("ID");
				String roomTypeName = results.getString("ROOMTYPENAME");
				String roomTypeInfo = results.getString("ROOMTYPEINFO");
				RoomType _newRoom = new RoomType(id, roomTypeName, roomTypeInfo);
				roomTypeList.add(_newRoom);
			}
			results.close();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return roomTypeList;
	}
}
