package wicket.quickstart;

import java.util.List;
public interface ICustomerCollection {
	public List<Customer> getCustomers();
	
	public void addCustomer(Customer Item);
	
	public void deleteCustomer(Customer Item);
	
	public void updateCustomer(Customer Item);
}
