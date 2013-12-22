package wicket.quickstart;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.Strings;

public class SignInPage extends WebPage {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPass;
	@Override
	protected void onInitialize() {
		super.onInitialize();
		StatelessForm form = new StatelessForm("userForm"){
			@Override
			protected void onSubmit() {
				if(Strings.isEmpty(userName))
					return;	
				boolean authResult = AuthenticatedWebSession.get().signIn(userName, userPass);
//	if authentication succeeds redirect user to the requested page
				if(authResult)
					continueToOriginalDestination();
			}
		};
		form.setDefaultModel(new CompoundPropertyModel(this));
		form.add(new TextField("userName"));
		form.add(new PasswordTextField("userPass"));
		add(form);
	}
}