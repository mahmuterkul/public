package wicket.quickstart;

public class ImageType {
	
		private Integer ImageTypeID;
		private String ImageTypeInfo;
		
		public ImageType(Integer Id, String ImageTypeInfo ){
			this.ImageTypeID = Id;
			this.ImageTypeInfo = ImageTypeInfo;
		}
		
		//setter methods
		public void setImageTypeID(Integer Id){
			this.ImageTypeID = Id;
		}
		public void setImageTypeID(String ImageTypeInfo){
			this.ImageTypeInfo = ImageTypeInfo;
		}
		
		//getter methods
		public Integer getImageTypeID(){
			return this.ImageTypeID;
		}
		public String getImageTypeInfo(){
			return this.ImageTypeInfo;
		}

}
