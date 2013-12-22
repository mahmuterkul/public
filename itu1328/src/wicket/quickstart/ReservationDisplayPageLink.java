package wicket.quickstart;

import org.apache.wicket.markup.html.link.Link;

public class ReservationDisplayPageLink extends Link {
    private Reservation _reservation;

    public ReservationDisplayPageLink(String id, Reservation reservation) {
        super(id);
        this._reservation = reservation;
    }

    @Override
    public void onClick() {
        this.setResponsePage(new ReservationDisplayPage(this._reservation));
    }
}