package AdminPanel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import wicket.quickstart.Room;

public class RoomDisplayPageLink extends Link {
	private Room _room;

	public RoomDisplayPageLink(String id, Room room) {
		super(id);
		this._room = room;
	}

	@Override
	public void onClick() {
		PageParameters param = new PageParameters();
		param.set(0, "admin");
		param.set(1, "admin");
		param.set(2, true);
		this.setResponsePage(new adminPanel(param));
	}
}
