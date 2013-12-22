package AdminPanel;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import wicket.quickstart.Activity;
import wicket.quickstart.ActivityCollectionJDBC;
import wicket.quickstart.Branch;
import wicket.quickstart.BranchCollectionJDBC;
import wicket.quickstart.News;
import wicket.quickstart.NewsCollectionJDBC;
import wicket.quickstart.WicketApplication;

public class newsList extends WebPage {
	private List<News> news_list;

	public newsList() {
		try {
			this.add(new adminNavigation("adminNavigation"));
			this.news_list = new LinkedList<News>();
			final WicketApplication app = (WicketApplication) this
					.getApplication();
			NewsCollectionJDBC _conn = new NewsCollectionJDBC(app.dbFilePath);
			news_list = _conn.getNews();
			PropertyListView roomListView = new PropertyListView("news_List",
					news_list) {
				@Override
				protected void populateItem(ListItem item) {
					final News _news = (News) item.getModelObject();
					item.add(new Label("newsTitle"));
					item.add(new Label("newsContent"));
					BranchCollectionJDBC _connB = new BranchCollectionJDBC(
							app.dbFilePath);
					List<Branch> _temp = _connB.getBranchs();
					int index = 0;
					for (int i = 0; i < _temp.size(); i++) {
						if (_temp.get(i).getBranchID() == _news.getBranchId()) {
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
							NewsCollectionJDBC _conn = new NewsCollectionJDBC(
									app.dbFilePath);
							_conn.deleteNews(_news);
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
