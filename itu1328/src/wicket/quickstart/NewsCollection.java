package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;

public class NewsCollection{
	private List<News> _newses;
	
	public NewsCollection() {
        this._newses = new LinkedList<News>();
    }

    public List<News> getNews() {
        return this._newses;
    }

    public void addNews(News news) {
        this._newses.add(news);
    }

    public void deleteNews(News news) {
        this._newses.remove(news);
    }

    public void updateNews(News news) {
    	
    }
	

}
