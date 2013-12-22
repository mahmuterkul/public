package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;

public class ImageTypeCollection {
	
	private List<ImageType>_imageTypeList;
	
	public ImageTypeCollection(){
		this._imageTypeList = new LinkedList<ImageType>();
	}
	public List<ImageType> getImageTypes(){
		return this._imageTypeList;		
	}
	public void addImageType(ImageType item){
		this._imageTypeList.add(item);
	}
	public void deleteImageType(ImageType item) {
		this._imageTypeList.remove(item);
	}
	public void updateImageType(ImageType item) {
		//this._empList.update(item);
	}
}
