package AdminPanel;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import wicket.quickstart.Branch;
import wicket.quickstart.BranchCollectionJDBC;
import wicket.quickstart.News;
import wicket.quickstart.NewsCollectionJDBC;
import wicket.quickstart.Organization;
import wicket.quickstart.OrganizationCollectionJDBC;
import wicket.quickstart.WicketApplication;

public class organizationList extends WebPage {
	private List<Organization> _orgList;

	public organizationList() {
		try {
			this.add(new adminNavigation("adminNavigation"));
			this._orgList = new LinkedList<Organization>();
			final WicketApplication app = (WicketApplication) this
					.getApplication();
			OrganizationCollectionJDBC _conn = new OrganizationCollectionJDBC(
					app.dbFilePath);
			_orgList = _conn.getOrganizations();
			PropertyListView roomListView = new PropertyListView(
					"organization_List", _orgList) {
				@Override
				protected void populateItem(ListItem item) {
					final Organization _org = (Organization) item
							.getModelObject();
					item.add(new Label("contactInfo"));
					BranchCollectionJDBC _connB = new BranchCollectionJDBC(
							app.dbFilePath);
					List<Branch> _temp = _connB.getBranchs();
					int index = 0;
					for (int i = 0; i < _temp.size(); i++) {
						if (_temp.get(i).getBranchID() == _org.getBranchId()) {
							index = i;
							break;
						}
					}
					item.add(new Label("BranchId", _temp.get(index)
							.getBranchName()));
					Button btnDelete = new Button("delete") {
						@Override
						public void onSubmit() {
							WicketApplication app = new WicketApplication();
							OrganizationCollectionJDBC _conn = new OrganizationCollectionJDBC(
									app.dbFilePath);
							_conn.deleteOrganization(_org);
						}
					};
					item.add(btnDelete);
				}
			};
			this.add(roomListView);

		} catch (Exception e) {

		}

	}
}
