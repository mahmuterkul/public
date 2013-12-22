package wicket.quickstart;

import java.util.List;

public interface IImageCollection {
	
	public List<Image> getImages();
	
	public void addImage(Image item);
	
	public void deleteImage(Image item);

	public void updateImage(Image item);

}
