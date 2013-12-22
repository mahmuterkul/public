package wicket.quickstart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ReservationCollectionJDBC implements IReservationCollection {
	private Connection _db;

	public ReservationCollectionJDBC(String dbFilePath) {

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

	public List<Reservation> getReservations() {
		List<Reservation> ReservationList = new LinkedList<Reservation>();
		try {
			String query = "SELECT ID,CUSTOMERID,BRANCHID,ROOMNO,ROOMTYPE,STARTDATE,ENDDATE FROM TBLRESERVATION";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				Integer ID = results.getInt("ID");
				Integer branchID = results.getInt("BRANCHID");
				Integer custID = results.getInt("CUSTOMERID");
				Integer roomNo = results.getInt("ROOMNO");
				Integer roomType = results.getInt("ROOMTYPE");
				String startDate = results.getString("STARTDATE");
				String endDate = results.getString("ENDDATE");
				Reservation _newReservation = new Reservation(ID, custID,
						branchID, roomNo, roomType, startDate, endDate);
				ReservationList.add(_newReservation);
			}
			results.close();
			statement.close();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		return ReservationList;
	}

	public List<Room> getAvailableRooms(Integer BranchID, String start, String end){
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String dateInString = start;
		Date dateIn = null;
		try {
			dateIn = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(date);

		Date dateOut = null;
		try {
			dateOut = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WicketApplication app = new WicketApplication();
		RoomCollectionJDBC _conn = new RoomCollectionJDBC(
				app.dbFilePath);
		List<Room> _roomsWithBranch = new LinkedList<Room>();
		_roomsWithBranch = _conn.getRoomsWithBranchID(BranchID);
		List<Reservation> ReservationList = new LinkedList<Reservation>();
		List<Room> _availableRoomList = new LinkedList<Room>();
		try{
			String s = BranchID.toString();
			String query = "SELECT ID,BRANCHID,CUSTOMERID,ROOMNO,ROOMTYPE,STARTDATE,ENDDATE FROM TBLRESERVATION WHERE(BRANCHID="+s+")";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				Integer ID = results.getInt("ID");
				Integer customerId = results.getInt("CUSTOMERID");
				Integer branchId = results.getInt("BRANCHID");
				Integer roomNo = results.getInt("ROOMNO");
				Integer roomType = results.getInt("ROOMTYPE");
				String startString = results.getString("STARTDATE");
				String endString = results.getString("ENDDATE");
				Reservation _reservation = new Reservation(ID,customerId,branchId, roomNo,roomType, startString, endString);
				System.out.print(roomNo);
				System.out.print(" ");
				ReservationList.add(_reservation);
			}
			for (int i = 0; i < ReservationList.size(); i++) {
				String sDate = ReservationList.get(i).getStartDate();
				String eDate = ReservationList.get(i).getEndDate();
				Date inDate = null;
				try {
					inDate = sdf.parse(dateInString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(date);

				Date outDate = null;
				try {
					outDate = sdf.parse(end);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int a = dateIn.compareTo(inDate);
				int b = dateOut.compareTo(inDate);
				int c = dateIn.compareTo(outDate);
				int d = dateOut.compareTo(outDate);
				if ((a<=0 && b>=0) || (c<=0 && d>=0) || (a>=0 && d<=0)) {
					for (int j = 0; j < _roomsWithBranch.size(); j++) {
						if (_roomsWithBranch.get(j).getId() == ReservationList.get(i).getRoomNo()) {
							_roomsWithBranch.remove(i);
						}
					}
				}
			}
			
		}catch(SQLException ex) {
			System.out.print(ex.toString());
		}
		return _roomsWithBranch;
	}

	public void addReservation(Reservation _newReservation) {
		try {
			String query = "INSERT INTO TBLRESERVATION (CUSTOMERID,BRANCHID,ROOMNO,ROOMTYPE,STARTDATE,ENDDATE) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			//statement.setInt(1, _newReservation.getID());
			statement.setInt(1, _newReservation.getCustID());
			statement.setInt(2, _newReservation.getBranchID());
			statement.setInt(3, _newReservation.getRoomNo());
			statement.setInt(4, _newReservation.getRoomType());
			statement.setString(5, _newReservation.getStartDate());
			statement.setString(6, _newReservation.getEndDate());
			statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void deleteReservation(Reservation _Reservation) {
		try {
			String query = "DELETE FROM TBLRESERVATION WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _Reservation.getID());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void UpdateReservation(Reservation _Reservation) {
		try {
			String query = "UPDATE TBLRESERVATION SET ID=?,CUSTOMERID=?,BRANCHID=?,ROOMNO=?, ROOMTYPE=? , STARTDATE=?,ENDDATE=? WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _Reservation.getID());
			statement.setInt(2, _Reservation.getCustID());
			statement.setInt(3, _Reservation.getBranchID());
			statement.setInt(4, _Reservation.getRoomNo());
			statement.setInt(5, _Reservation.getRoomType());
			statement.setString(6, _Reservation.getStartDate());
			statement.setString(7, _Reservation.getEndDate());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
}
