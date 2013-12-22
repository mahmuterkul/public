package wicket.quickstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OrganizationCollectionJDBC implements IOrganizationCollection {
    private Connection _db;
    
    public OrganizationCollectionJDBC(String dbFilePath) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }

        try {
            String jdbcURL = "jdbc:sqlite:" + dbFilePath;
            this._db = DriverManager.getConnection(jdbcURL);
        } catch (SQLException ex) {
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }
    
    public List<Organization> getOrganizations() {
        List<Organization> organizations = new LinkedList<Organization>();
        try {
            String query = "SELECT ID, CONTACTINFO, BRANCHID FROM ORGANIZATION";
            Statement statement = this._db.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                Integer id = results.getInt("ID");
                String contactInfo = results.getString("CONTACTINFO");
                Integer branchId = results.getInt("BRANCHID");
                Organization organization = new Organization(id, contactInfo, branchId);
                organizations.add(organization);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return organizations;
    }
    
    
    public void addOrganization(Organization organization) {
        try {
            String query = "INSERT INTO ACTIVIES (CONTACTINFO, BRANCHID) VALUES (?, ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, organization.getContactInfo());
            statement.setInt(2, organization.getBranchId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void deleteOrganization(Organization organization) {
        try {
            String query = "DELETE FROM ACTIVITY WHERE (ID = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setInt(1, organization.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public void updateOrganization(Organization organization) {
        try {
            String query = "UPDATE MOVIE SET CONTACTINFO = ?, BRANCHID = ?  WHERE (ID = ?)";
            PreparedStatement statement = this._db.prepareStatement(query);
            statement.setString(1, organization.getContactInfo());
            statement.setInt(2, organization.getBranchId());
            statement.setInt(3, organization.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }
    
    
    
}