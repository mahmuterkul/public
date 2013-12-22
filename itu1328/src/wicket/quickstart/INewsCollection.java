package wicket.quickstart;
import java.util.List;

public interface INewsCollection {
	public List<News> getNews();
	public void addNews(News news);
	public void deleteNews(News news);
	public void updateNews(News news);
}
