package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

	public class Session extends AuthenticatedWebSession {
		public Session(Request request) {
			super(request);
		}
		@Override
		public boolean authenticate(String username, String password) {
			//user is authenticated if both username and password are equal to 'wicketer'
			boolean authResult = false;
			WicketApplication app = (WicketApplication) this.getApplication();
	        ICustomerCollection collection = app.getCustomerCollection();
	        List<Customer> customer = collection.getCustomers();
	        if (customer.size() >= 0) {
	        	 for (int i = 0; i < customer.size(); i++) {
	 				if (customer.get(i).getCustMail().equals(username))
	 				{
	 					if (customer.get(i).getCustName().equals(password)) {
	 						authResult = true;
		 					break;
						}
	 					
	 				}
	 			}
			}
	       
	       
			return (username.equals(password) && username.equals("user") || authResult);
		}
		@Override
		public Roles getRoles() {
			return null;
		}
}