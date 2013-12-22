package wicket.quickstart;

import java.util.List;

public interface IImageTypeCollection {
	public List<ImageType> getImageTypes();
	
	public void addImageType (ImageType item);
	
	public void deleteImageType(ImageType item);

	public void updateImageType(ImageType item);

}
