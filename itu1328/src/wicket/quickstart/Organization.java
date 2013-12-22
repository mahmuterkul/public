package wicket.quickstart;

public class Organization {
    private int id = -1;
	private String contactInfo = null;
    private int branchId = -1;

    public Organization() {
    }

    
    public Organization(int id, String contactInfo,int branchId){
    	this.setId(id);
    	this.setContactInfo(contactInfo); 
    	this.setBranchId(branchId); 
    	 
    }
    
    public void setId(int anId){
    	this.id = anId;
    	
    }
    
    public int getId(){
    	return this.id;	
    }
  
    
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public String getContactInfo() {
        return this.contactInfo;
    }

    
    public int getBranchId(){
    	return this.branchId;	
    }
    
    public void setBranchId(int branchId){
    	this.branchId = branchId;
    	
    }
}
