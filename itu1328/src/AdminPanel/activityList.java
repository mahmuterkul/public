package AdminPanel;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import wicket.quickstart.Activity;
import wicket.quickstart.ActivityCollectionJDBC;
import wicket.quickstart.Branch;
import wicket.quickstart.BranchCollectionJDBC;
import wicket.quickstart.Room;
import wicket.quickstart.RoomCollectionJDBC;
import wicket.quickstart.WicketApplication;

public class activityList extends WebPage {
	private List<Activity> activity_list;

	public activityList() {
		try {
			this.add(new adminNavigation("adminNavigation"));
			this.activity_list = new LinkedList<Activity>();
			final WicketApplication app = (WicketApplication) this
					.getApplication();
			ActivityCollectionJDBC _conn = new ActivityCollectionJDBC(
					app.dbFilePath);
			activity_list = _conn.getActivities();
			PropertyListView roomListView = new PropertyListView(
					"activity_List", activity_list) {
				@Override
				protected void populateItem(ListItem item) {
					final Activity _act = (Activity) item.getModelObject();
					item.add(new Label("title"));
					item.add(new Label("info"));
					item.add(new Label("startHour"));
					item.add(new Label("endHour"));
					BranchCollectionJDBC _connB = new BranchCollectionJDBC(
							app.dbFilePath);
					List<Branch> _temp = _connB.getBranchs();
					int index = 0;
					for (int i = 0; i < _temp.size(); i++) {
						if (_temp.get(i).getBranchID() == _act.getBranchId()) {
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
							ActivityCollectionJDBC _conn = new ActivityCollectionJDBC(
									app.dbFilePath);
							_conn.deleteActivity(_act);
						}
					};
					item.add(btnDelete);
				}
			};
			this.add(roomListView);
		} catch (Exception e) {
			System.out.print("exception : " + e);
		}
	}
}
