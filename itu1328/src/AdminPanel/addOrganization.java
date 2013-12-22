package AdminPanel;

import java.util.ArrayList;
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
import wicket.quickstart.Organization;
import wicket.quickstart.OrganizationCollectionJDBC;
import wicket.quickstart.RoomType;
import wicket.quickstart.WicketApplication;
import AdminPanel.addNews.addNewsForm;

public class addOrganization extends WebPage {
	private DropDownChoice<String> drpBranch;
	private List<Branch> _BranchList;

	public addOrganization() {
		this.add(new adminNavigation("adminNavigation"));
		WicketApplication app = new WicketApplication();
		BranchCollectionJDBC _conn = new BranchCollectionJDBC(app.dbFilePath);
		_BranchList = _conn.getBranchs();
		this.add(new addNewsForm("addOrganization"));

	}

	public class addNewsForm extends Form {
		private List<String> branch;
		private String contactInfo;

		public addNewsForm(String id) {
			super(id);
			branch = new ArrayList<String>();
			for (int i = 0; i < _BranchList.size(); i++) {
				branch.add(_BranchList.get(i).getBranchName().toString());
			}
			setDefaultModel(new CompoundPropertyModel(this));
			add(new TextArea<String>("contactInfo"));
			drpBranch = new DropDownChoice<String>("branch", new Model(),
					branch);
			add(drpBranch);
			//add(new Label("resultStatus"));
		}

		public final void onSubmit() {
			WicketApplication app = new WicketApplication();
			System.out.print("path : " + app.dbFilePath);
			OrganizationCollectionJDBC _conn = new OrganizationCollectionJDBC(
					app.dbFilePath);
			Integer x = _BranchList.get(Integer.parseInt(drpBranch.getValue()))
					.getBranchID();
			Organization _org = new Organization(-1, contactInfo, x);
			_conn.addOrganization(_org);
			/*
			 * resultStatus = newsTitle + "  " + newsContent + "  " +
			 * drpnewsType.getModelObject() + "  " + drpBranch.getModelObject();
			 */
		}
	}
}
