package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class ImageTypeCollectionJDBC implements IImageTypeCollection {
	private Connection _db;
	
	public ImageTypeCollectionJDBC(String dbFilePath){
		
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
	
	public List<ImageType> getImageTypes(){
		
		List<ImageType> imageTypeList = new LinkedList<ImageType>();
		try{
			
			String query =  "SELECT ID,IMAGETYPEINFO FROM TBLIMAGETYPE";
			Statement statement = this._db.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while(results.next()){
				Integer ID = results.getInt("ID");
				String imageTypeInfo = results.getString("IMAGETYPEINFO");
				ImageType _newImageType = new ImageType(ID,imageTypeInfo);
				imageTypeList.add(_newImageType);
			}
			
			results.close();
			statement.close();	
		}
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
		
		return imageTypeList;
	}

	public void addImageType(ImageType _newImageType){
		try{
			String query = "INSERT INTO TBLEMPLOYEE (IMAGETYPEINFO VALUES(?,?))";
			PreparedStatement statement = this._db.prepareStatement(query);
			//statement.setInt(1, _newImageType.getImageTypeID());
			statement.setString(1, _newImageType.getImageTypeInfo());
			statement.executeUpdate();
		}
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	
	public void deleteImageType(ImageType _imageType){
		try {
			String query = "DELETE FROM TBLIMAGETYPE WHERE (ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _imageType.getImageTypeID());
			statement.executeUpdate();
			statement.close();

		} 
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
	
	public void updateImageType(ImageType _imageType){
		try{
			String query = "UPDATE TBLIMAGETYPE SET ID=?, IMAGETYPEINFO=? WHERE(ID=?)";
			PreparedStatement statement = this._db.prepareStatement(query);
			statement.setInt(1, _imageType.getImageTypeID());
			statement.setString(2, _imageType.getImageTypeInfo());
			
			statement.executeUpdate();
			statement.close();
		} 
		catch (SQLException ex) {
			System.out.print(ex.toString());
		}
	}
}