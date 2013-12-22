package wicket.quickstart;
import java.util.List;

public interface IOrganizationCollection {
	public List<Organization> getOrganizations();
	public void addOrganization(Organization organization);
	public void deleteOrganization(Organization organization);
	public void updateOrganization(Organization organization);
}
