package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;

public class ImageCollection {
	
	private List<Image>_imageList;
	
	public ImageCollection(){
		this._imageList = new LinkedList<Image>();
	}
	public List<Image> getImages(){
		return this._imageList;		
	}
	public void addImage(Image item){
		this._imageList.add(item);
	}
	public void deleteImage(Image item) {
		this._imageList.remove(item);
	}
	public void updateImage(Image item) {
		//this._empList.update(item);
	}

}
