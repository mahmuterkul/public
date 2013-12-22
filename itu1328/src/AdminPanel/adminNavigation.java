package AdminPanel;

import org.apache.wicket.examples.base.HomePage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import wicket.quickstart.BranchPage;
import wicket.quickstart.WicketApplication;

public class adminNavigation extends Panel {
	public adminNavigation(String id) {
		super(id);

		Link addRoomLink = new Link("addRoom") {
			@Override
			public void onClick() {
				PageParameters param = new PageParameters();
				param.set(0, "admin");
				param.set(1, "admin");
				param.set(2, false);
				this.setResponsePage(adminPanel.class, param);
			}
		};
		this.add(addRoomLink);

		Link editRoomLink = new Link("roomList") {
			@Override
			public void onClick() {
				this.setResponsePage(roomList.class);
			}
		};
		this.add(editRoomLink);
		Link addActivityLink = new Link("addActivity") {
			@Override
			public void onClick() {
				setResponsePage(addActivity.class);
			}
		};
		this.add(addActivityLink);
		Link ActivityListLink = new Link("activityList") {
			@Override
			public void onClick() {
				setResponsePage(activityList.class);
			}
		};
		this.add(ActivityListLink);
		Link addNewsLink = new Link("addNews") {
			@Override
			public void onClick() {
				setResponsePage(addNews.class);
			}
		};
		this.add(addNewsLink);
		Link editNewsLink = new Link("newsList") {
			@Override
			public void onClick() {
				setResponsePage(newsList.class);
			}
		};
		this.add(editNewsLink);
		Link addOrganizationLink = new Link("addOrganization") {
			@Override
			public void onClick() {
				setResponsePage(addOrganization.class);
			}
		};
		this.add(addOrganizationLink);
		Link organizationListLink = new Link("organizationList") {
			@Override
			public void onClick() {
				setResponsePage(organizationList.class);
			}
		};
		this.add(organizationListLink);
		Link addBranchLink = new Link("addBranch") {
			@Override
			public void onClick() {
				setResponsePage(addBranch.class);
			}
		};
		this.add(addBranchLink);
		Link branchListLink = new Link("branchList") {
			@Override
			public void onClick() {
				setResponsePage(branchList.class);
			}
		};
		this.add(branchListLink);
		Link homePageLink = new Link("homePage") {
			@Override
			public void onClick() {
				//setResponsePage(new HomePage());
				WicketApplication app = new WicketApplication();
				app.getHomePage();
			}
		};
		this.add(homePageLink);
	}

}
