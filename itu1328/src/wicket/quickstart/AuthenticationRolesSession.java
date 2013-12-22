package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

class BasicAuthenticationRolesSession extends AuthenticatedWebSession {
	private String userName;
	public BasicAuthenticationRolesSession(Request request) {
		super(request);
}
	@Override
	public boolean authenticate(String username, String password) {
		boolean authResult= false;
		WicketApplication app = (WicketApplication) this.getApplication();
	        ICustomerCollection collection = app.getCustomerCollection();
	        List<Customer> customer = collection.getCustomers();
	        LinkedList _custList = new LinkedList(customer);
	        for (int i = 0; i < customer.size(); i++) {
				if (customer.get(i).getCustMail().equals(username)&& customer.get(i).getCustPass().equals(password)) {
					authResult = true;
					break;
				}
			}
	        ListIterator iterator = _custList.listIterator(0);
	        
	       /* Customer input = new Customer();
	        input.setCustMail(username);
	        input.setCustPass(password);
	        if(true){
  	        	authResult = true;
  	        }
  	        else{
  	        	authResult = false;
  	        	}*/
	        
				if(authResult)
					userName = username;
		return authResult;
	}
	@Override
	public Roles getRoles() {
		Roles resultRoles = new Roles();
		if(isSignedIn())
			resultRoles.add("SIGNED_IN");
		if(userName.equals("admin"))
			resultRoles.add(Roles.ADMIN);
		return resultRoles;
	}
}