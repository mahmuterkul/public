package wicket.quickstart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.datetime.markup.html.form.DateTextField;

import AdminPanel.adminNavigation;
import AdminPanel.loginPage;

public class UserPage extends BasePage{
	private static final long serialVersionUID = 1L;
//	public UserPage(){
//		this.add(new NavigationPanel("mainNavigation"));
//		ReservationListForm reservationListForm = new ReservationListForm("reservationForm");
//		this.add(reservationListForm);
//	}
	
	public UserPage(Customer customer){
		this.add(new Label("name",customer.getCustName()));
		this.add(new Label("contact",customer.getCustInfo()));
		this.add(new Label("mail",customer.getCustMail()));
		ReservationListForm reservationListForm = new ReservationListForm("reservationForm");
		//RoomListForm roomListForm = new RoomListForm("roomForm");
	    this.add(reservationListForm);
	    //this.add(roomListForm);
		
	}
	
	public class ReservationListForm extends Form {
	    private List<Reservation> _selectedReservations;

	    public ReservationListForm(String id) {
	        super(id);
	       // this._selectedReservations = new LinkedList<Reservation>();

	       // CheckGroup reservationCheckGroup =
	         //       new CheckGroup("selectedReservations", this._selectedReservations);
	        //this.add(reservationCheckGroup);

	        WicketApplication app = (WicketApplication) this.getApplication();
	        ReservationCollectionJDBC _conn = new ReservationCollectionJDBC(app.dbFilePath);
	     //   IRoomCollection roomCollection = app.getRoomCollection();

	        List<Reservation> reservations = _conn.getReservations();
	       // List<Room> rooms = roomCollection.getRooms();
	        
	        
	        
	        PropertyListView reservationListView =
	                new PropertyListView("reservationList", reservations) {
	            @Override
	            protected void populateItem(ListItem item) {
	            	final Reservation _temp = (Reservation)item.getModelObject();
	               // ReservationDisplayPageLink reservationLink =
	                 //       new ReservationDisplayPageLink("reservationLink", reservation);
	                item.add(new Label("branchID"));
	                item.add(new Label("roomType"));
	                item.add(new Label("startDate"));
	                item.add(new Label("endDate"));
	                //item.add(new Check("selected", item.getModel()));
	            }
	            
	        };this.add(reservationListView);
	      
	       
	        	//reservationCheckGroup.add(reservationListView);
//	        Button button = new Button("delete"){
//	        	 @Override
//	     	    public void onSubmit() {
//	     	        WicketApplication app = (WicketApplication) this.getApplication();
//	     	        IReservationCollection reservationCollection = app.getReservationCollection();
//	     	        for (Reservation reservation : _selectedReservations)
//	     	           // reservationCollection.deleteReservation(reservation);
//	     	        this.setResponsePage(HomePage.class);
//	     	    }
//	        	 
//	        };//this.add("reservationListForm");
	        	
	    }
	    
	   	        		    		
    
	    
	   
	  
	    
	}
	
//	public class RoomListForm extends Form {
//
//	    public RoomListForm(String id) {
//	        super(id);
//
//	        WicketApplication app = (WicketApplication) this.getApplication();
//	        //IReservationCollection reservationCollection = app.getReservationCollection();
//	        IRoomCollection roomCollection = app.getRoomCollection();
//	        //List<Reservation> reservations = reservationCollection.getReservations();
//	        List<Room> rooms = roomCollection.getRooms();
//	        
//	        
//	        PropertyListView roomListView =
//	                new PropertyListView("roomList", rooms) {
//	            @Override
//	            protected void populateItem(ListItem item) {
//	            	Room room = (Room) item.getModelObject();
//	            	item.add(new Label("roomType"));
//	            	item.add(new Label("roomNo"));
//	            	item.add(new Label("roomStatus"));
//	            	item.add(new Label("roomPrice"));
//	            	item.add(new Label("branchId"));
//	            	//item.add(new Label("roomNo"));
//	            }
//	        };
//	        this.add(roomListView);
//	        	
//	        	
//	    }
//	   	        		    		
//    
//	    
//	    @Override
//	    public void onSubmit() {
//	        WicketApplication app = (WicketApplication) this.getApplication();
//	        IRoomCollection roomCollection = app.getRoomCollection();
//	        
//	        
//	        this.setResponsePage(HomePage.class);
//	    }
//	  
//	    
//	}
	
	
	
	/*
	 * public class addReservation extends Form { private List<String> roomType
	 * = Arrays.asList("Normal", "Exclusive", "Suit"); private String
	 * roomNumber; private String roomPrice; private List<String> branch =
	 * Arrays.asList("Istanbul", "Ankara", "Izmir"); private String
	 * resultStatus;
	 * 
	 * public addReservation(String id) { super(id); setDefaultModel(new
	 * CompoundPropertyModel(this)); drpRoomType = new
	 * DropDownChoice<String>("roomType", new Model(), roomType);
	 * add(drpRoomType); add(new TextField("roomNumber")); add(new
	 * TextField("roomPrice")); drpBranch = new DropDownChoice<String>("branch",
	 * new Model(),branch); add(drpBranch); add(new Label("resultStatus")); }
	 * 
	 * public final void onSubmit() { WicketApplication app = new
	 * WicketApplication(); System.out.print("path : " + app.dbFilePath);
	 * RoomCollectionJDBC _conn = new RoomCollectionJDBC(app.dbFilePath);
	 * 
	 * Room _newRoom = new Room(null, Integer.parseInt(drpRoomType.getValue()),
	 * Integer.parseInt(roomNumber), 0, Integer.parseInt(roomPrice),
	 * Integer.parseInt((drpBranch.getValue()))); _conn.addroom(_newRoom);
	 * 
	 * resultStatus = drpRoomType.getModelObject() + "  " + roomNumber + "  " +
	 * roomPrice + "  " + drpBranch.getModelObject(); ''''''''''
	 */

}