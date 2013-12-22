package wicket.quickstart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
//import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.datetime.markup.html.form.DateTextField;

import AdminPanel.loginPage;

public class ReservationPage2 extends WebPage {
	public List<Room> _roomsBranch = new ArrayList<Room>();
	private static final long serialVersionUID = 1L;
	
	  @Override protected void onConfigure() { AuthenticatedWebApplication app
	  = (AuthenticatedWebApplication)Application.get(); // if user is not
	  //signed in, redirect him to sign in page
	  if(!AuthenticatedWebSession.get().isSignedIn())
	  app.restartResponseAtSignInPage(); }
	 
	 /* @Override protected void onInitialize() { super.onInitialize(); /*add(new
	 * Link("HomePage") {
	 * 
	 * @Override public void onClick() {
	 * setResponsePage(getApplication().getHomePage()); } }); /*add(new
	 * Link("logOut") {
	 * 
	 * @Override public void onClick() {
	 * AuthenticatedWebSession.get().invalidate();
	 * setResponsePage(getApplication().getHomePage()); } });
	 */
	// }
	private DropDownChoice<String> drpDay1;
	private DropDownChoice<String> drpMonth1;
	private DropDownChoice<String> drpYear1;
	private DropDownChoice<String> drpDay2;
	private DropDownChoice<String> drpMonth2;
	private DropDownChoice<String> drpYear2;
	private DropDownChoice<Integer> drpNum;
	private DropDownChoice<String> drpBranch;

	public ReservationPage2() {
		this.add(new ReservationForm("enter_reservation"));
		this.add(new NavigationPanel("nav"));
	}

	public class ReservationForm extends Form {
		private List<String> dayNumber1 = Arrays.asList("01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31");
		private List<String> MonthNumber1 = Arrays.asList("01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12");
		private List<String> yearNumber1 = Arrays.asList("2013", "2014",
				"2015", "2016");
		private List<String> dayNumber2 = Arrays.asList("01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31");
		private List<String> MonthNumber2 = Arrays.asList("01", "02", "03", "04",
				"05", "06", "07", "08", "09", "10", "11", "12");
		private List<String> yearNumber2 = Arrays.asList("2013", "2014",
				"2015", "2016");
		private List<Integer> numberOfRooms = Arrays.asList(1, 2, 3, 4, 5, 6,
				7, 8, 9);
		private List<Branch> _branches = new LinkedList<Branch>();
		private List<String> _branchList = new ArrayList<String>();

		public ReservationForm(String id) {
			super(id);
			WicketApplication app = new WicketApplication();
			BranchCollectionJDBC _conn = new BranchCollectionJDBC(
					app.dbFilePath);
			_branches = _conn.getBranchs();
			CompoundPropertyModel model = new CompoundPropertyModel(this);
			this.setModel(model);

			for (int i = 0; i < _branches.size(); i++) {
				_branchList.add(_branches.get(i).getBranchName());
			}

			drpBranch = new DropDownChoice<String>("branch", new Model(),
					_branchList);
			this.add(drpBranch);
			// setDefaultModel(new CompoundPropertyModel(this));
			drpDay1 = new DropDownChoice<String>("giris_gunu", new Model(),
					dayNumber1);
			this.add(drpDay1);
			drpMonth1 = new DropDownChoice<String>("giris_ayi", new Model(),
					MonthNumber1);
			this.add(drpMonth1);
			drpYear1 = new DropDownChoice<String>("giris_yili", new Model(),
					yearNumber1);
			this.add(drpYear1);
			drpDay2 = new DropDownChoice<String>("cikis_gunu", new Model(),
					dayNumber2);
			this.add(drpDay2);
			drpMonth2 = new DropDownChoice<String>("cikis_ayi", new Model(),
					MonthNumber2);
			this.add(drpMonth2);
			drpYear2 = new DropDownChoice<String>("cikis_yili", new Model(),
					yearNumber2);
			this.add(drpYear2);
			drpNum = new DropDownChoice<Integer>("numberOfRooms", new Model(),
					numberOfRooms);
			this.add(drpNum);
			Button button = new Button("submitForm") {
				@Override
				public final void onSubmit() {
					// Reservation reservation = (Reservation)
					// this.getModelObject();
					// WicketApplication app = (WicketApplication)
					// this.getApplication();
					String in = drpDay1.getDefaultModelObjectAsString()
							+ drpMonth1.getDefaultModelObjectAsString()
							+ drpYear1.getDefaultModelObjectAsString();
					String out = drpDay2.getDefaultModelObjectAsString()
							+ drpMonth2.getDefaultModelObjectAsString()
							+ drpYear2.getDefaultModelObjectAsString();

					SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
					String dateInString = in;
					java.util.Date dateIn = null;
					try {
						dateIn = sdf.parse(dateInString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// System.out.println(date);

					java.util.Date dateOut = null;
					try {
						dateOut = sdf.parse(dateInString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// System.out.println(date);

					Integer numOfRooms;
					numOfRooms = Integer.parseInt(drpNum.getValue()) + 1;
					// System.out.println(numOfRooms);
					PageParameters params = new PageParameters();
					params.set(1, in);
					params.set(2, out);
					params.set(3, numOfRooms);
					setResponsePage(HomePage.class);

					WicketApplication app = new WicketApplication();
					RoomCollectionJDBC _conn = new RoomCollectionJDBC(
							app.dbFilePath);
					//List<Room> _roomsWithBranch = new LinkedList<Room>();
					//_roomsWithBranch = _conn.getRoomsWithBranchID(1);
					 java.sql.Date sqlDateIn = new java.sql.Date(dateIn.getTime());
					 java.sql.Date sqlDateOut = new java.sql.Date(dateOut.getTime());
					ReservationCollectionJDBC _connR = new ReservationCollectionJDBC(
							app.dbFilePath);
					List<Room> _availableRoomList = new LinkedList<Room>();
					_availableRoomList = _connR.getAvailableRooms(1, in, out);
					
					this.setResponsePage(new ReservationPage3(1,params));

				}
			};
			this.add(button);
		}
	}
}
