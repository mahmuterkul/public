package wicket.quickstart;

public class News  {
	private Integer id;
	private String newsTitle = null;
	private String newsContent = null;
	private String newsType = null;
	private int branchId = -1;

	public News() {

	}

	public News(int id, String newsTitle, String newsContent, String newsType,
			int branchId) {
		this.setId(id);
		this.setNewsTitle(newsTitle);
		this.setNewsContent(newsContent);
		this.setNewsType(newsType);
		this.setBranchId(branchId);
	}

	public void setId(int anId) {
		this.id = anId;

	}

	public Integer getId() {
		return this.id;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getNewsType() {
		return this.newsType;
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;

	}
}
