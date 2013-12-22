package wicket.quickstart;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class ReservationCollection implements IReservationCollection {
	private List<Reservation> _reservationList;
	private List<Room> _availableRoomList;

	public ReservationCollection() {
		this._reservationList = new LinkedList<Reservation>();
	}
	
	public List<Room> getAvailableRooms(Integer BranchID, String startDate, String endDate){
		return this._availableRoomList;
	}

	public List<Reservation> getReservations() {
		return this._reservationList;
	}

	public void addReservation(Reservation item, Integer numOfRooms) {
		this._reservationList.add(item);
	}

	public void deleteReservation(Reservation item) {
		this._reservationList.remove(item);
	}

	public void updateReservation(Reservation item) {
	}
}
