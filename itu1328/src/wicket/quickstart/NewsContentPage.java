package wicket.quickstart;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Date;

import org.apache.velocity.runtime.directive.Parse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class NewsContentPage extends BasePage {
	public NewsContentPage(PageParameters param) {

		WicketApplication appl = (WicketApplication) this.getApplication();
		INewsCollection collection = appl.getNewsCollection();
		List<News> newsContent = collection.getNews();
		
		Integer index = 0;
		for (int i = 0; i < newsContent.size(); i++) {
			if (param.get(1).toInt() == newsContent.get(i).getId()) {
				index = i;
				break;
			}
		}
		
		List<News> _temp = new ArrayList<News>();
		_temp.add(newsContent.get(index));
		PropertyListView newsContentListView = new PropertyListView(
				"content_list", _temp) {
			@Override
			protected void populateItem(ListItem item) {
				item.add(new Label("newsContent"));
			}
		};
		this.add(newsContentListView);

	}

}
