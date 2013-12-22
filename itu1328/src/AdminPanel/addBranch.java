package AdminPanel;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import wicket.quickstart.Branch;
import wicket.quickstart.BranchCollectionJDBC;
import wicket.quickstart.News;
import wicket.quickstart.NewsCollectionJDBC;
import wicket.quickstart.WicketApplication;
import AdminPanel.addNews.addNewsForm;

public class addBranch extends WebPage {

	public addBranch() {
		this.add(new adminNavigation("adminNavigation"));
		this.add(new addNewsForm("addBranch"));
	}

	public class addNewsForm extends Form {
		private String BranchName;
		private String BranchAddress;
		private String BranchPhone;

		public addNewsForm(String id) {
			super(id);
			setDefaultModel(new CompoundPropertyModel(this));
			add(new TextField("BranchName"));
			add(new TextField("BranchAddress"));
			add(new TextField("BranchPhone"));
		}

		public final void onSubmit() {
			WicketApplication app = new WicketApplication();
			BranchCollectionJDBC _conn = new BranchCollectionJDBC(
					app.dbFilePath);
			Branch _newBranch = new Branch(-1, BranchName, BranchAddress,
					BranchPhone);
			_conn.addBranch(_newBranch);
			
		}
	}
}
