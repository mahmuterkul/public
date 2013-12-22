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
import wicket.quickstart.Room;
import wicket.quickstart.RoomCollectionJDBC;
import wicket.quickstart.RoomType;
import wicket.quickstart.WicketApplication;

public class branchList extends WebPage {
	private List<Branch> _branchList;

	public branchList() {
		try {
			this.add(new adminNavigation("adminNavigation"));
			this._branchList = new LinkedList<Branch>();
			WicketApplication app = (WicketApplication) this.getApplication();
			BranchCollectionJDBC _conn = new BranchCollectionJDBC(
					app.dbFilePath);
			_branchList = _conn.getBranchs();
			PropertyListView roomListView = new PropertyListView("branch_List",
					_branchList) {
				@Override
				protected void populateItem(ListItem item) {
					final Branch _branch = (Branch) item.getModelObject();
					item.add(new Label("BranchName"));
					item.add(new Label("BranchAddress"));
					item.add(new Label("BranchPhone"));
					Button btnDelete = new Button("delete") {
						@Override
						public void onSubmit() {
							WicketApplication app = new WicketApplication();
							BranchCollectionJDBC _conn = new BranchCollectionJDBC(
									app.dbFilePath);
							_conn.deleteBranch(_branch);
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
