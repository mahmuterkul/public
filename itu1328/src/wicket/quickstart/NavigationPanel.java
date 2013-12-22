package wicket.quickstart;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import AdminPanel.adminPanel;
import AdminPanel.loginPage;

public class NavigationPanel extends Panel {
	public NavigationPanel(final String id) {
		super(id);

		Link homePageLink = new Link("home") {
			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
			}
		};
		this.add(homePageLink);

		Link haberLink = new Link("haberler") {
			@Override
			public void onClick() {
				 this.setResponsePage(NewsPage.class);
			}
		};
		this.add(haberLink);

		Link hakkimizdaLink = new Link("hakkimizda") {
			@Override
			public void onClick() {
				this.setResponsePage(new AboutUsPage());
			}
		};
		this.add(hakkimizdaLink);
		
		Link loginLink = new Link("login") {
			@Override
			public void onClick() {
				PageParameters param = new PageParameters();
				this.setResponsePage(new loginPage(param));
			}
		};
		this.add(loginLink);

		
//		Link adminLink = new Link("admin") {
//			@Override
//			public void onClick() {
//				// Movie movie = new Movie();
//				this.setResponsePage(adminPanel.class);
//			}
//		};
//		this.add(adminLink);
		
		Link bookLink = new Link("Book"){	
			@Override
			public void onClick(){
				this.setResponsePage(new ReservationPage2());
			}
		};
		this.add(bookLink);
		
		
		Link subeLink = new Link("subeler"){	
			@Override
			public void onClick(){
				this.setResponsePage(BranchPage.class);
			}
		};
		this.add(subeLink);
		
		Link userLink = new Link("user"){	
			Customer customer = new Customer();
			@Override
			public void onClick(){
				this.setResponsePage(new UserPage(customer));
			}
		};
		this.add(userLink);
		
		Link registerLink = new Link("register") {
			@Override
			public void onClick() {
				//Customer customer = new Customer();
				this.setResponsePage(RegisterPage.class);
			}
		};
		this.add(registerLink);
		
		
	}


}