package AdminPanel;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import wicket.quickstart.Activity;
import wicket.quickstart.ActivityCollectionJDBC;
import wicket.quickstart.Room;
import wicket.quickstart.RoomCollectionJDBC;
import wicket.quickstart.WicketApplication;

public class addActivity extends WebPage {
	private DropDownChoice<String> drpBranch;
	private DropDownChoice<String> drpactStartHour;
	private DropDownChoice<String> drpactEndHour;
	private TextArea<String> txtactInfo;

	public addActivity() {
		this.add(new adminNavigation("adminNavigation"));
		this.add(new addActivityForm("addActivity"));
	}

	public class addActivityForm extends Form {
		private String actTitle;
		private String actInfo;
		private List<String> actStartHour = Arrays.asList("00", "01", "02",
				"03", "04", "05", "06", "07", "08", "09", "10", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22", "23", "24");
		// private String actStartHour;
		private List<String> actEndHour = Arrays.asList("00", "01", "02", "03",
				"04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31", "32", "33",
				"34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50", "51", "52", "53",
				"54", "55", "56", "57", "58", "59", "60");
		// private String actEndHour;
		private List<String> branch = Arrays.asList("Istanbul", "Ankara",
				"Izmir");
		private String resultStatus;

		public addActivityForm(String id) {
			super(id);
			setDefaultModel(new CompoundPropertyModel(this));
			add(new TextField("actTitle"));
			// txtactInfo=;
			add(new TextArea<String>("actInfo"));
			drpactStartHour = new DropDownChoice<String>("actStartHour",
					new Model(), actStartHour);
			drpactEndHour = new DropDownChoice<String>("actEndHour",
					new Model(), actEndHour);
			drpBranch = new DropDownChoice<String>("branch", new Model(),
					branch);
			add(drpBranch);
			add(drpactStartHour);
			add(drpactEndHour);
			add(new Label("resultStatus"));
		}

		public final void onSubmit() {
			WicketApplication app = new WicketApplication();
			System.out.print("path : " + app.dbFilePath);
			ActivityCollectionJDBC _conn = new ActivityCollectionJDBC(
					app.dbFilePath);
			Activity _newAct = new Activity(-1, actTitle, actInfo,
					drpactStartHour.getModelObject().toString(), drpactEndHour
							.getModelObject().toString(),
					Integer.parseInt((drpBranch.getValue())));

			_conn.addActivity(_newAct);
			// RoomCollectionJDBC _conn = new
			// RoomCollectionJDBC(app.dbFilePath);

			/*
			 * Room _newRoom = new Room(null, Integer.parseInt(drpRoomType
			 * .getValue()), Integer.parseInt(roomNumber), 0,
			 * Integer.parseInt(roomPrice), Integer.parseInt((drpBranch
			 * .getValue()))); _conn.addroom(_newRoom);
			 */

			resultStatus = actTitle + "  " + actInfo + "  "
					+ drpactStartHour.getModelObject().toString() + "  "
					+ drpactEndHour.getModelObject().toString() + " "
					+ drpBranch.getModelObject();
		}
	}
}
