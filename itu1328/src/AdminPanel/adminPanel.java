package AdminPanel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import wicket.quickstart.Branch;
import wicket.quickstart.BranchCollectionJDBC;
import wicket.quickstart.NavigationPanel;
import wicket.quickstart.Room;
import wicket.quickstart.RoomCollectionJDBC;
import wicket.quickstart.RoomType;
import wicket.quickstart.WicketApplication;
import AdminPanel.loginPage.LoginForm;

public class adminPanel extends WebPage {
	private DropDownChoice<String> drpRoomType;
	private DropDownChoice<String> drpBranch;
	private List<RoomType> _roomTypeList;
	private List<Branch> _branchList;

	public adminPanel(PageParameters parameters) {
		try {

			if (parameters.isEmpty()) {
				setResponsePage(loginPage.class);
			} else if (parameters.get(0).equals("admin")
					&& parameters.get(1).equals("admin")) {
				setResponsePage(loginPage.class);
			}
			this.add(new adminNavigation("adminNavigation"));
			WicketApplication app = new WicketApplication();
			RoomType _temp = new RoomType();
			_temp.RoomTypeCollectionJDBC(app.dbFilePath);
			_roomTypeList = _temp.getRoomTypes();
			BranchCollectionJDBC _conn = new BranchCollectionJDBC(
					app.dbFilePath);
			_branchList = _conn.getBranchs();
			this.add(new addRoom("addRoom"));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public class addRoom extends Form {
		private List<String> roomType;
		private String roomNumber;
		private String roomPrice;
		private List<String> branch;

		// = Arrays.asList("Istanbul", "Ankara","Izmir");
		private String resultStatus;

		public addRoom(String id) {
			super(id);
			roomType = new ArrayList<String>();
			branch = new ArrayList<String>();
			try {
				for (int i = 0; i < _roomTypeList.size(); i++) {
					roomType.add(_roomTypeList.get(i).getRoomTypeName()
							.toString());
				}
				for (int i = 0; i < _branchList.size(); i++) {
					branch.add(_branchList.get(i).getBranchName());
				}
			} catch (Exception e) {
				System.out.print(e);
			}
			setDefaultModel(new CompoundPropertyModel(this));
			drpRoomType = new DropDownChoice<String>("roomType", new Model(),
					roomType);
			add(drpRoomType);
			add(new TextField("roomNumber"));
			add(new TextField("roomPrice"));
			drpBranch = new DropDownChoice<String>("branch", new Model(),
					branch);
			add(drpBranch);
			add(new Label("resultStatus"));
		}

		public final void onSubmit() {
			WicketApplication app = new WicketApplication();
			System.out.print("path : " + app.dbFilePath);
			RoomCollectionJDBC _conn = new RoomCollectionJDBC(app.dbFilePath);
			Integer x = _roomTypeList.get(
					Integer.parseInt(drpRoomType.getValue())).getRoomTypeId();
			Room _newRoom = new Room(null, x, Integer.parseInt(roomNumber), 0,
					Integer.parseInt(roomPrice), Integer.parseInt((drpBranch
							.getValue())));
			_conn.addroom(_newRoom);
			resultStatus = "Room Successfully Added";
			/*
			 * resultStatus += drpRoomType.getModelObject() + "  " + roomNumber
			 * + "  " + roomPrice + "  " + drpBranch.getModelObject();
			 */
		}
	}
}
