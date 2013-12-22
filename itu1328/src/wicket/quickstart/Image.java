package wicket.quickstart;

public class Image {
	
	private Integer ImageID;
	private String ImageSource;
	private Integer ImageType;
	private Integer UsedID;
	private Integer BranchID;
	
	public Image(Integer ImID, String ImSource, Integer ImType, Integer UsedID, Integer BrnID){
		this.ImageID = ImID;
		this.ImageSource = ImSource;
		this.ImageType = ImType;
		this.UsedID = UsedID;
		this.BranchID = BrnID;
	}
	
	//setter methods
	
	public void setImageID(Integer Id){
		this.ImageID = Id;
	}
	public void setImageSource(String ImSource){
		this.ImageSource = ImSource;
	}
	public void setImageType(Integer ImType){
		this.ImageType = ImType;
	}
	public void setUsedID(Integer UsedID){
		this.UsedID = UsedID;
	}
	public void setBranchID(Integer BranchID){
		this.BranchID = BranchID;
	}
	
	//getter methods
	public Integer getImageID(){
		return this.ImageID;
	}
	public String getImageSource(){
		return this.ImageSource;
	}
	public Integer getImageType(){
		return this.ImageType;
	}
	public Integer getUsedID(){
		return this.UsedID;
	}
	public Integer getBranchID(){
		return this.BranchID;
	}
	
}

