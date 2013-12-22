package wicket.quickstart;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class RegisterPage extends BasePage{
	public RegisterPage(Customer customer){
			this.add(new RegisterForm("registerForm",customer));
			
				
	}
		
	public class RegisterForm extends Form{
		
		public RegisterForm(String id,Customer customer){
			super(id);
			
			CompoundPropertyModel model = new CompoundPropertyModel(customer);
			this.setModel(model);
			
			this.add(new TextField("custName"));
			this.add(new TextField("custInfo"));
			this.add(new TextField("custMail"));
			this.add(new TextField("custPass"));	
			//this.add(new TextField("custPassAgain"));
			
		}
		@Override
		public void onSubmit(){
			
			Customer cust = (Customer) this.getModelObject();
			WicketApplication app = (WicketApplication) this.getApplication();
			ICustomerCollection collection = app.getCustomerCollection();
			collection.addCustomer(cust);
			this.setResponsePage(new UserPage(cust));
		}
		
	}
		
	

}
