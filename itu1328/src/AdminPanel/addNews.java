package AdminPanel;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import wicket.quickstart.Activity;
import wicket.quickstart.ActivityCollectionJDBC;
import wicket.quickstart.News;
import wicket.quickstart.NewsCollectionJDBC;
import wicket.quickstart.WicketApplication;
import AdminPanel.addActivity.addActivityForm;

public class addNews extends WebPage {
	// private FileUploadField fileUpload;
	// private String UPLOAD_FOLDER = "C:\\Users\\MUHAMMED\\Desktop";
	private DropDownChoice<String> drpBranch;
	private DropDownChoice<String> drpnewsType;
	private TextArea<String> txtNewsContent;

	public addNews() {
		this.add(new adminNavigation("adminNavigation"));
		this.add(new addNewsForm("addNews"));
	}

	public class addNewsForm extends Form {
		private String newsTitle;
		private String newsContent;
		private List<String> newsType = Arrays.asList("Home Page",
				"Detail Page");
		private List<String> branch = Arrays.asList("Istanbul", "Ankara",
				"Izmir");
		private String resultStatus;

		public addNewsForm(String id) {
			super(id);
			setDefaultModel(new CompoundPropertyModel(this));
			add(new TextField("newsTitle"));
			// txtactInfo=;
			add(new TextArea<String>("newsContent"));
			drpnewsType = new DropDownChoice<String>("newsType", new Model(),
					newsType);
			drpBranch = new DropDownChoice<String>("branch", new Model(),
					branch);
			add(drpBranch);
			add(drpnewsType);
			add(new Label("resultStatus"));
		}

		public final void onSubmit() {
			WicketApplication app = new WicketApplication();
			System.out.print("path : " + app.dbFilePath);
			NewsCollectionJDBC _conn = new NewsCollectionJDBC(app.dbFilePath);
			News _news = new News(-1, newsTitle, newsContent,
					drpnewsType.getValue(), Integer.parseInt((drpBranch
							.getValue())));
			_conn.addNews(_news);
			// RoomCollectionJDBC _conn = new
			// RoomCollectionJDBC(app.dbFilePath);

			/*
			 * Room _newRoom = new Room(null, Integer.parseInt(drpRoomType
			 * .getValue()), Integer.parseInt(roomNumber), 0,
			 * Integer.parseInt(roomPrice), Integer.parseInt((drpBranch
			 * .getValue()))); _conn.addroom(_newRoom);
			 */

			resultStatus = newsTitle + "  " + newsContent + "  "
					+ drpnewsType.getModelObject() + "  "
					+ drpBranch.getModelObject();
		}
	}
}
