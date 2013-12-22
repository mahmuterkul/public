package wicket.quickstart;

import java.io.File;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;


public class WicketApplication extends AuthenticatedWebApplication  {
	private IBranchCollection branchCollection;
	private INewsCollection newsCollection;
	private IFacilityCollection facilityCollection;
	private IRoomCollection _roomCollectionWithBranch;
	private IReservationCollection _reservationCollection;
	private IRoomCollection roomCollection;
	private IReservationCollection reservationCollection;

	private ICustomerCollection customerCollection;
	String homeDir = System.getProperty("user.home");
	public String dbFilePath = homeDir + File.separator +"Desktop"+File.separator+ "hotel.sqlite";
	
	
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass(){
		return Session.class;
	}
	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return SignInPage.class;
	}
	
	
	@Override
	public void init() {
		super.init();

		String homeDir = System.getProperty("user.home");
		String dbFilePath = homeDir + File.separator +"Desktop"+File.separator+ "hotel.sqlite";
		this.branchCollection = new BranchCollectionJDBC(dbFilePath);
		this.newsCollection = new NewsCollectionJDBC(dbFilePath);
		this.facilityCollection = new FacilityCollectionJDBC(dbFilePath);
		this.customerCollection = new CustomerCollectionJDBC(dbFilePath);
	}
	
	
	
	public IBranchCollection getBranchCollection() {
		return this.branchCollection;
	}
	public INewsCollection getNewsCollection() {
		return this.newsCollection;
	}
	public IFacilityCollection getFacilityCollection() {
		return this.facilityCollection;
	}
	public ICustomerCollection getCustomerCollection() {
		return this.customerCollection;
	}
	public IRoomCollection getRoomCollection() {
		return this.roomCollection;
	}
	public IReservationCollection getReservationCollection() {
		return this.reservationCollection;
	}



}