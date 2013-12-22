package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ImageCollectionJDBC implements IImageCollection {
	
	private Connection _db;
	
	public ImageCollectionJDBC(String dbFilePath){
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			System.out.print(ex.toString());
		}
		try {
			String jdbcURL = "jdbc:sqlite:" + dbFilePath;
			this._db = DriverManager.getConnection(jdbcURL);
		} catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	
	public List<Image> getImages(){
		
		List<Image> imageList = new LinkedList<Image>();
		try{
			
			String query =  "SELECT ID,IMGSOURCE,IMGTYPE,IMGUSEDID,BRANCHID FROM TBLIMAGE";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while(results.next()){
				Integer ID = results.getInt("ID");
				String imageSource = results.getString("IMGSOURCE");
				Integer imageType = results.getInt("IMGTYPE");
				Integer imageUsedID = results.getInt("IMGUSEDID");
				Integer branchID = results.getInt("BRANCHID");
				Image _newImage = new Image(ID,imageSource,imageType,imageUsedID,branchID);
				imageList.add(_newImage);
			}
			
			results.close();
			statement.close();
			
		}
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		
		return imageList;
	}

	public void addImage(Image _newImage){
		try{
			String query = "INSERT INTO TBLIMAGE (IMGSOURCE,IMGTYPE,IMGUSEDID,BRANCHID VALUES(?,?,?,?,?))";
			PreparedStatement statement = this._db.prepareStatement(query);
			//statement.setInt(1, _newImage.getImageID());
			statement.setString(1, _newImage.getImageSource());
			statement.setInt(2, _newImage.getImageType());
			statement.setInt(3, _newImage.getUsedID());
			statement.setInt(4, _newImage.getBranchID());
			statement.executeUpdate();
		}
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}	

	public void deleteImage(Image _image){
		try {
			String query = "DELETE FROM TBLIMAGE WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _image.getImageID());
			statement.executeUpdate();
			statement.close();

		} 
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}

	public void updateImage(Image _image){
		try{
			String query = "UPDATE TBLIMAGE SET ID=?, IMGSOURCE=?, IMGTYPE=?, IMGUSEDID=?, BRANCHID=? WHERE(ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _image.getImageID());
			statement.setString(2, _image.getImageSource());
			statement.setInt(3, _image.getImageType());
			statement.setInt(4, _image.getUsedID());
			statement.setInt(5, _image.getBranchID());
			
			statement.executeUpdate();
			statement.close();
		} 
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
}
