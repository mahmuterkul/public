package wicket.quickstart;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import AdminPanel.adminNavigation;

public class ReservationPage3 extends WebPage {
	private List<Room> _roomList;
	private List<Room> _roomList2;
	private static final long serialVersionUID = 1L;

	public ReservationPage3(final Integer BranchId,final PageParameters param) {
		try {
			this.add(new NavigationPanel("mainNavigation"));
			java.util.Date now = new java.util.Date();
	        this.add(new Label("datetime", now.toString()));
			// this.add(new RoomListForm("roomListForm"));
			this._roomList = new LinkedList<Room>();
			WicketApplication app = (WicketApplication) this.getApplication();
			ReservationCollectionJDBC _conn = new ReservationCollectionJDBC(app.dbFilePath);
			String d1 = param.get(1).toString();
			String d2 = param.get(2).toString();
			_roomList = _conn.getAvailableRooms(BranchId, d1, d2);
			
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
					item.add(new Label("RoomPrice"));
					item.add(new Link("reserve"){
						public void onClick(){
							WicketApplication app = new WicketApplication();
							ReservationCollectionJDBC _conn = new ReservationCollectionJDBC(app.dbFilePath);
							String date1 = param.get(1).toString();
							String date2 = param.get(2).toString();
							SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
					
//							java.util.Date dateIn = null;
//							try {
//								dateIn = sdf.parse(date1);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							// System.out.println(date);
//
//							java.util.Date dateOut = null;
//							try {
//								dateOut = sdf.parse(date2);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							//SimpleDateFormat sdfb = new SimpleDateFormat("dd-M-yyyy");
							//String sqlDateIn = sdf.
							//String sqlDateOut = sdf.format(date2);
							System.out.print(date1);


							
							
							
							
							Reservation reservation = new Reservation(-1, 1, BranchId, room.getId(), room.getType(), date1, date2);
							_conn.addReservation(reservation);						
							}
						});
					
				}
			};
			this.add(roomListView);
		} catch (Exception e) {
			System.out.print("exception : " + e);
		}
	}
}

