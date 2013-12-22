package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;

public class FacilityCollection {
	
	private List<Facility>_facilityList;
	
	public FacilityCollection(){
		this._facilityList = new LinkedList<Facility>();
	}
	public List<Facility> getFacilities(){
		return this._facilityList;		
	}
	public void addFacility(Facility item){
		this._facilityList.add(item);
	}
	public void deleteFacility(Facility item) {
		this._facilityList.remove(item);
	}
	public void updateFacility(Facility item) {
		//this._empList.update(item);
	}
	public List<Facility> getSpecificFacilities(double id){
		return this._facilityList;		
	}

}
