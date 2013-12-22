package wicket.quickstart;

public class Activity {
    private int id = -1;
	private String title = null;
    private String info = null;
    private String startHour = null;
    private String endHour = null;
    private int branchId = -1;

    public Activity() {
    }
    
    public Activity(int id, String title,String info,String startHour,String endHour, int branchId){
    	this.setId(id);
    	this.setTitle(title);
    	this.setInfo(info);
    	this.setStartHour(startHour); 
    	this.setEndHour(endHour); 
    	this.setBranchId(branchId); 
    	 
    }
    
    public void setId(int anId){
    	this.id = anId;
    	
    }
    
    public int getId(){
    	return this.id;	
    }
  
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getStartHour() {
        return this.startHour;
    }
    
    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndHour() {
        return this.endHour;
    }
    

    public int getBranchId(){
    	return this.branchId;	
    }
    
    public void setBranchId(int branchId){
    	this.branchId = branchId;
    	
    }
}
