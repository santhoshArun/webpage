package alpha;

import java.sql.*;

public class Delete {
	
	static Connection connection = null;
	static Statement statement = null;
	
	public static int deleteUser(String user) {
		int status = 0;
		
		try {
			connection = DBconnecter.getConnection();
			statement = connection.createStatement();
			String sql = "delete from login where username = '"+ user +"'" ;
			status = statement.executeUpdate(sql);
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}		
		return status;
	}

}
