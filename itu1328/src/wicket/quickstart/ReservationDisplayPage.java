package wicket.quickstart;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ReservationDisplayPage extends WebPage{
	private Reservation _reservation;
	public ReservationDisplayPage(Reservation reservation){
		this._reservation = reservation;

        this.add(new Label("branchId", reservation.getBranchID()));
        this.add(new Label("roomType", reservation.getRoomType()));
        this.add(new Label("startDate", reservation.getStartDate()));
        this.add(new Label("endDate", reservation.getEndDate()));
		
	}
	
	public Reservation getReservation() {
        return this._reservation;
    }

}
