package AdminPanel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import wicket.quickstart.HomePage;
import wicket.quickstart.WicketApplication;

public final class loginPage extends WebPage {
	public loginPage(final PageParameters parameters) {
		super(parameters);
		add(new LoginForm("loginForm"));
	}

	public class LoginForm extends Form {
		private String usermail;
		private String password;
		private String loginStatus;

		public LoginForm(String id) {
			super(id);
			setDefaultModel(new CompoundPropertyModel(this));
			add(new TextField("usermail"));
			add(new PasswordTextField("password"));
			add(new Label("loginStatus"));
		}

		public final void onSubmit() {
			if (usermail.equals("admin") && password.equals("admin"))
			{
				PageParameters param = new PageParameters();
				param.set(0,"admin");
				param.set(1,"admin");
				setResponsePage(adminPanel.class,param);
			}
			else
				loginStatus = "Wrong username or password !";
		}
	}

}
