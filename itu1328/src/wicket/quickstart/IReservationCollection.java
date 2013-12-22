package wicket.quickstart;

import java.sql.Date;
import java.util.List;

public interface IReservationCollection {
	public List<Reservation> getReservations();
	public List<Room> getAvailableRooms(Integer BranchID, String startDate, String endDate);
	//public void addReservation(Reservation item);

	//public void deleteReservation(Reservation item);

	//public void updateReservation(Reservation item);
}