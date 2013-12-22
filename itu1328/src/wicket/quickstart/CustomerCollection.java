package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;
public class CustomerCollection {
	private List<Customer>_custList;
	
	public CustomerCollection(){
		this._custList = new LinkedList<Customer>();
	}
	
	public List<Customer> getCustomers(){
		return this._custList;
	}
	
	public void addCustomer(Customer Item){
		this._custList.add(Item);
	}
	
	public void deleteCustomer(Customer Item){
		this._custList.remove(Item);
	}
	
	public void updateCustomer(Customer Item){
		//this._custList.set(index, Item);
	}
}
