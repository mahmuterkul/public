package wicket.quickstart;


import java.util.List;
import java.io.Serializable;
import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
//import org.apache.wicket.markup.html.list.ListView;
//import org.apache.wicket.markup.html.panel.Panel;
//import org.apache.wicket.request.mapper.parameter.PageParameters;
//import org.apache.wicket.markup.html.form.Button;
//import org.apache.wicket.markup.html.form.Form;
//import org.apache.wicket.markup.html.form.IFormSubmitter;
//import org.apache.wicket.markup.html.form.validation.IFormValidator;

public class BranchPage extends BasePage{
	public BranchPage(){
		
		
		
		
		
		WicketApplication appl = (WicketApplication) this.getApplication();
		IBranchCollection collection = appl.getBranchCollection();
		List<Branch> branchs = collection.getBranchs();
		
		PropertyListView branchListView =
		        new PropertyListView("branch_list", branchs) {
		            @Override
		            protected void populateItem(ListItem item) {
		                final Branch branche = (Branch) item.getModelObject();
		            	item.add(new Label("BranchName"));
		                item.add(new Label("BranchAddress"));
		                item.add(new Label("BranchPhone"));
		                
		                item.add(new Label("BranchId"));
		                //final String st = msg.toString();
		                item.add(new Link("link"){
		                	public void onClick(){
		                		PageParameters page = new PageParameters(); 
		                		page.set(1,branche.getBranchID());
		                		this.setResponsePage(new FacilityPage(page));
		                	}
		                });
		            }

					private double getParametre(String string) {
						double a = Double.parseDouble(string);
						System.out.println("getParametre fonksiyonu");
						return a;
					}

				
			};
		        this.add(branchListView);	
		        
	}
	 	 
}