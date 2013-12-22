package wicket.quickstart;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class RoomCollectionJDBC implements IRoomCollection {
	private Connection _db;

	public RoomCollectionJDBC(String dbFilePath) {

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

	public List<Room> getRooms() {
		List<Room> roomList = new LinkedList<Room>();
		try {
			String query = "SELECT ID, ROOMTYPE, ROOMNO,ROOMSTATUS,ROOMPRICE,BRANCHID FROM TBLROOM";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				Integer id = results.getInt("ID");
				Integer roomType = results.getInt("ROOMTYPE");
				Integer roomNo = results.getInt("ROOMNO");
				Integer roomStatus = results.getInt("ROOMSTATUS");
				Integer roomPrice = results.getInt("ROOMPRICE");
				Integer branchId = results.getInt("BRANCHID");
				Room _newRoom = new Room(id, roomType, roomNo, roomStatus,
						roomPrice, branchId);
				roomList.add(_newRoom);
			}
			results.close();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return roomList;
	}

	public List<Room> getRoomsWithBranchID(Integer BranchId) {
		List<Room> RoomList = new LinkedList<Room>();
		try {
			String query = "SELECT ID, ROOMTYPE, ROOMNO, ROOMPRICE FROM TBLROOM WHERE (BRANCHID = ?)";
			// PreparedStatement statement = this._db.prepareStatement(query);
			// Statement statement2 = this._db.createStatement();
			PreparedStatement statement = _db.prepareStatement(query);
			statement.setInt(1, BranchId);
			// statement.executeUpdate();
			ResultSet results = statement.executeQuery();
			// ResultSet results = statement2.executeQuery(query);
			while (results.next()) {
				Integer ID = results.getInt("ID");
				Integer roomType = results.getInt("ROOMTYPE");
				Integer roomNo = results.getInt("ROOMNO");
				Integer roomPrice = results.getInt("ROOMPRICE");
				Room _room = new Room(ID, roomType, roomNo, roomPrice);
				//System.out.print(roomNo);
				RoomList.add(_room);
			}

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return RoomList;
	}

	public void addroom(Room _newRoom) {
		try {
			String query = "INSERT INTO TBLROOM (ROOMTYPE, ROOMNO,ROOMSTATUS,ROOMPRICE,BRANCHID) VALUES (?, ?,?,?,?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _newRoom.getType());
			statement.setInt(2, _newRoom.getNo());
			statement.setInt(3, _newRoom.getStatus());
			statement.setInt(4, _newRoom.getPrice());
			statement.setInt(5, _newRoom.getBranch());
			statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void deleteroom(Room _room) {
		try {
			String query = "DELETE FROM TBLROOM WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _room.getId());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void updateroom(Room _room) {
		try {
			String query = "UPDATE TBLROOM SET ROOMTYPE=?,ROOMNO=? , ROOMSTATUS=?,ROOMPRICE=?,BRANCHID=? WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _room.getType());
			statement.setInt(2, _room.getNo());
			statement.setInt(3, _room.getStatus());
			statement.setInt(4, _room.getPrice());
			statement.setInt(5, _room.getBranch());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
}
