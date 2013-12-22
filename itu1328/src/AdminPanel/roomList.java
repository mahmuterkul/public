package AdminPanel;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import wicket.quickstart.Branch;
import wicket.quickstart.BranchCollectionJDBC;
import wicket.quickstart.Room;
import wicket.quickstart.RoomCollectionJDBC;
import wicket.quickstart.RoomType;
import wicket.quickstart.WicketApplication;

public class roomList extends WebPage {
	private List<Room> _roomList;

	public roomList() {
		try {
			this.add(new adminNavigation("adminNavigation"));
			// this.add(new RoomListForm("roomListForm"));
			this._roomList = new LinkedList<Room>();
			WicketApplication app = (WicketApplication) this.getApplication();
			RoomCollectionJDBC _conn = new RoomCollectionJDBC(app.dbFilePath);
			_roomList = _conn.getRooms();
			PropertyListView roomListView = new PropertyListView("room_List",
					_roomList) {
				@Override
				protected void populateItem(ListItem item) {
					final Room room = (Room) item.getModelObject();
					WicketApplication app = new WicketApplication();
					RoomType _temp2 = new RoomType();
					_temp2.RoomTypeCollectionJDBC(app.dbFilePath);
					List<RoomType> _type = _temp2.getRoomTypes();
					int index2 = 0;
					for (int i = 0; i < _type.size(); i++) {
						if (_type.get(i).getRoomTypeId() == room.getId()) {
							index2 = i;
							break;
						}
					}
					item.add(new Label("RoomType", _type.get(index2)
							.getRoomTypeName()));
					item.add(new Label("RoomNo"));

					BranchCollectionJDBC _connB = new BranchCollectionJDBC(
							app.dbFilePath);
					List<Branch> _temp = _connB.getBranchs();
					int index = 0;
					for (int i = 0; i < _temp.size(); i++) {
						if (_temp.get(i).getBranchID() == room.getBranch()) {
							index = i;
							break;
						}
					}
					item.add(new Label("BranchId", _temp.get(index)
							.getBranchName()));
					Button btnDelete = new Button("delete") {
						@Override
						public void onSubmit() {
							WicketApplication app = new WicketApplication();
							RoomCollectionJDBC _conn = new RoomCollectionJDBC(
									app.dbFilePath);
							_conn.deleteroom(room);
						}
					};
					item.add(btnDelete);
				}
			};
			this.add(roomListView);
		} catch (Exception e) {
			System.out.print("exception : " + e);
		}
	}
}
