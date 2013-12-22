package AdminPanel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class spCaller {
	public static ResultSet CallSp(String sqlCommand,String ...parameters ) {
		String connectionString = "jdbc:sqlserver://94.73.149.8;"
				+ "databaseName=Hotel;"
				+ "user=USR131128155312;password=Ysfeksim2013;";
		ResultSet resultSet = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(connectionString);

			int i = 1;
			CallableStatement callableStatement = connection
					.prepareCall(sqlCommand);
			callableStatement.setEscapeProcessing(true);
			callableStatement.setQueryTimeout(3600);
			for (String parameter : parameters) {
				callableStatement.setString(i, parameter);
				i++;
			}
			resultSet = callableStatement.executeQuery();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sqlCommand);
			preparedStatement.setEscapeProcessing(true);
			preparedStatement.setQueryTimeout(3600);

			for (String parameter : parameters) {
				preparedStatement.setString(i, parameter);
				i++;
			}
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
