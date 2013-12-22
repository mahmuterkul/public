package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;

public class OrganizationCollection implements IOrganizationCollection {
	private List<Organization> _organizations;
	
	public OrganizationCollection() {
        this._organizations = new LinkedList<Organization>();
    }

    public List<Organization> getOrganizations() {
        return this._organizations;
    }

    public void addOrganization(Organization organization) {
        this._organizations.add(organization);
    }

    public void deleteOrganization(Organization organization) {
        this._organizations.remove(organization);
    }

    public void updateOrganization(Organization organization) {
    	
    }
	

}
