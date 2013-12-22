package wicket.quickstart;

import java.util.List;
import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class NewsPage extends BasePage {
	public NewsPage() {

		WicketApplication app = (WicketApplication) this.getApplication();
		INewsCollection collection = app.getNewsCollection();
		List<News> news = collection.getNews();

		PropertyListView newsListView = new PropertyListView("haberler_list",
				news) {
			@Override
			protected void populateItem(ListItem item) {
				final News _temp = (News)item.getModelObject();
				item.add(new Label("newsTitle"));
				// item.add(new Label("newsContent"));
				// item.add(new Label("newsType"));
				item.add(new Link("news_link") {
					public void onClick() {
						PageParameters param = new PageParameters();
						param.set(1, _temp.getId());
						this.setResponsePage(new NewsContentPage(param));
					}
				});
			}
		};
		this.add(newsListView);

	}

}