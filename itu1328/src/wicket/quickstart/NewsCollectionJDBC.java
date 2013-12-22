package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class NewsCollectionJDBC implements INewsCollection {
	private Connection _db;

	public NewsCollectionJDBC(String dbFilePath) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}

		try {
			String jdbcURL = "jdbc:sqlite:" + dbFilePath;
			this._db = DriverManager.getConnection(jdbcURL);
		} catch (SQLException ex) {
			throw new UnsupportedOperationException(ex.getMessage());
		}
	}

	public List<News> getNews() {
		List<News> newses = new LinkedList<News>();
		try {
			String query = "SELECT ID, NEWSTITLE, NEWSCONTENT, NEWSTYPE, BRANCHID FROM TBLNEWS";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				Integer id = results.getInt("ID");
				String newsTitle = results.getString("NEWSTITLE");
				String newsContent = results.getString("NEWSCONTENT");
				String newsType = results.getString("NEWSTYPE");
				Integer branchId = results.getInt("BRANCHID");
				News news = new News(id, newsTitle, newsContent, newsType,
						branchId);
				newses.add(news);
			}
			results.close();
			statement.close();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
		return newses;
	}

	public void addNews(News news) {
		try {
			String query = "INSERT INTO TBLNEWS (NEWSTITLE, NEWSCONTENT, NEWSTYPE, BRANCHID) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setString(1, news.getNewsTitle());
			statement.setString(2, news.getNewsContent());
			statement.setString(3, news.getNewsType());
			statement.setInt(4, news.getBranchId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
	}

	public void deleteNews(News news) {
		try {
			String query = "DELETE FROM TBLNEWS WHERE (ID = ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, news.getId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
	}

	public void updateNews(News news) {
		try {
			String query = "UPDATE TBLNEWS SET NEWSTITLE = ?, NEWSCONTENT = ?, NEWSTYPE = ?, BRANCHID = ?  WHERE (ID = ?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setString(1, news.getNewsTitle());
			statement.setString(2, news.getNewsContent());
			statement.setString(3, news.getNewsType());
			statement.setInt(4, news.getBranchId());
			statement.setInt(5, news.getId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
	}

}