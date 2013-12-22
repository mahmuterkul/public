package wicket.quickstart;

import java.util.List;

public interface IFacilityCollection {
	
	public List<Facility> getFacilities();
	
	public List<Facility> getSpecificFacilities(double id);
	
	
	public void addFacility(Facility item);
	
	public void deleteFacility(Facility item);
	
	public void updateFacility(Facility item);
	
}
